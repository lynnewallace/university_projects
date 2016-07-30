import os
import re
import zlib
import hashlib

# locations of dataset
doc_loc = './0829961/'

# output files
file_exact = open('./exact.txt', 'w')
file_near = open('./near.txt', 'w')
file_finn = open('./finn.txt', 'w')

# structures for comparisons
exact_hash = {}
near_hash = {}
near_written = []

# variable sizes
group_size = 8
fingerprint_size = 32
slope_size = 100

# stop words taken from nltk
stopword_list = ['i', 'me', 'my', 'myself', 'we', 'our', 'ours', 'ourselves', 'you', 'your', 'yours', 'yourself', 'yourselves', 'he', 'him', 'his', 'himself', 'she', 'her', 'hers', 'herself', 'it', 'its', 'itself', 'they', 'them', 'their', 'theirs', 'themselves', 'what', 'which', 'who', 'whom', 'this', 'that', 'these', 'those', 'am', 'is', 'are', 'was', 'were', 'be', 'been', 'being', 'have', 'has', 'had', 'having', 'do', 'does', 'did', 'doing', 'a', 'an', 'the', 'and', 'but', 'if', 'or', 'because', 'as', 'until', 'while', 'of', 'at', 'by', 'for', 'with', 'about', 'against', 'between', 'into', 'through', 'during', 'before', 'after', 'above', 'below', 'to', 'from', 'up', 'down', 'in', 'out', 'on', 'off', 'over', 'under', 'again', 'further', 'then', 'once', 'here', 'there', 'when', 'where', 'why', 'how', 'all', 'any', 'both', 'each', 'few', 'more', 'most', 'other', 'some', 'such', 'no', 'nor', 'not', 'only', 'own', 'same', 'so', 'than', 'too', 'very', 's', 't', 'can', 'will', 'just', 'don', 'should', 'now']

#### GENERAL ####

# write duplicate output in correct format to appropriate file
def write_out(filename, dup1, dup2):
  filename.write("{0}-{1}\n".format(dup1, dup2))

# return content of file as a list of its lines
def grab_text(file_name):
  prep = []
  for line in open(doc_loc + file_name, 'r'):
    prep.append(line)

  return prep

#### EXACT DUPLICATE ####

def preprocess_exact(doc):
  # get file contents
  prep = grab_text(doc)
  content = ''

  # remove non content
  for line in prep[1:]:
    content += re.sub('[\W_]+', '', line)

  # make case insensitive
  return content.lower()
  
def exact_dup_check(doc, name):
  # adler32 preprocessed doc
  adlered = zlib.adler32(doc)

  # does it clash
  if adlered in exact_hash:
    
    # write out duplicates
    for dup_name in exact_hash[adlered]:
      write_out(file_exact, dup_name, name)

    # update dict
    exact_hash[adlered].append(name)
  else:
    # update dict
    exact_hash[adlered] = [name]

#### NEAR DUPLICATE ####

# weight is frequency of word in document
def assign_weights(words):
  weights = {}

  for word in words:
    # already seen
    if word in weights:
      # update count 
      weights[word] += 1
    else:
      # add weight
      weights[word] = 1

  return weights

# unique hash is 32 char string of binary bits
# uses last 32 bits of md5 digest for word
def calculate_unique_hash(words):
  uniques = {}

  for word in words:
    # generate hash for word 
    uniques[word] = str(bin(int(hashlib.md5(word).hexdigest(), 16))[-fingerprint_size:])  

  return uniques

def preprocess_near(doc):
  # get file contents
  prep = grab_text(doc)
  words = []

  for line in prep[1:]:
    # remove non content
    content = re.sub('[^a-zA-Z0-9 ]+', '', line)
    # get words, make case insensitive and remove stop words
    words.extend([con.lower() for con in content.split() if con.lower() not in stopword_list])

  # get weights and unqiue hashes of words
  weights = assign_weights(words)
  unique_hashes = calculate_unique_hash(weights.keys())

  return [unique_hashes, weights]

def calculate_fingerprint(hashes, weights):
  fingerprint = [0] * fingerprint_size

  for h in hashes:
    # for each bit of the hash, make value -weight if bit is 0, +weight if bit is 1
    word = [-1 * weights[h] if bit == '0' else 1 * weights[h] for bit in hashes[h]]
    # update fingerprint with word hash values
    fingerprint = map(sum, zip(fingerprint, word))

  # make binary, bit is 0 if negative number, 1 if positive
  fingerprint = [1 if bit > 0 else 0 for bit in fingerprint]
      
  # return as string
  return "".join([str(bit) for bit in fingerprint])    

# return number of differing bits between fingerprints
def hamming_distance(fingerprint1, fingerprint2):
  return sum(bit1 != bit2 for bit1, bit2 in zip(fingerprint1, fingerprint2))

def near_dup_check(data, name):
  hashes = data[0]
  weights = data[1]

  # generate fingerprint
  fingerprint = calculate_fingerprint(hashes, weights)
  # split fingerprint into a number of groups
  groupings = [fingerprint[i:i + group_size] for i in range(0, fingerprint_size, group_size)]

  # check each group
  for group in groupings:

    # does it clash
    if group in near_hash:  
      # check for similarities
      for dup in near_hash[group]:
        # must be a different fingerprint and not already written out
        if name != dup[0] and [name, dup] not in near_written:
          # check how similar
          hamming = hamming_distance(fingerprint, dup[1])
          # if very similar
          if (hamming < 2):
            write_out(file_near, dup[0], name)
            near_written.append([name, dup])

      # update dict if needed
      if [name, fingerprint] not in near_hash[group]:
        near_hash[group].append([name, fingerprint])
    else:
      # update dict
      near_hash[group] = [[name, fingerprint]]
      
#### FINN ####

def preprocess_finn(doc):
  # get file contents
  prep = grab_text(doc)
  words = []

  for line in prep[1:]:
    # remove non content
    content = re.sub('[^a-zA-Z0-9 ]+', '', line)
    # get words and make case insensitive
    words.extend([con.lower() for con in content.split()])

  return words

def finn_dup_check(doc, name):
  tags = 0.0
  non_tags = 0.0
  plateau = [0, 0]
  best = 0.0
  l = 0.0

  for i in range(len(doc)):
    if doc[i].isdigit():
      non_tags += 1
    else:
      l += 1
      tags += 1
      
    m = 0.0
    for j in range(i, len(doc)): 
      if doc[j].isdigit():
        non_tags += 1
        m += (tags / non_tags)
      else:
        tags += 1

      r = 0.0
      for k in range(j, len(doc)): 
        if doc[k].isdigit():
          non_tags += 1
        else:
          r += 1
          tags += 1

      if l + m + r > best:
        best = l + m + r
        plateau = [i, j]

  print plateau

# get documents
train_set = os.listdir(doc_loc)

# check documents for duplication
for doc in train_set:
  exact_dup_check(preprocess_exact(doc), doc[:-4])  
  near_dup_check(preprocess_near(doc), doc[:-4])
  #finn_dup_check(preprocess_finn(doc), doc[:-4])

# close files
file_exact.close()
file_near.close()
file_finn.write(" ")
file_finn.close()
