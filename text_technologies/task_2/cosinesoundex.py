import re
import math

file_docs = open('./docs.txt', 'r')
file_qrys = open('./qrys.txt', 'r')
file_top = open('./cosinesoundex.top', 'w')

qrys = []
for line in file_qrys:
  qrys.append(line.split())

docs = []
for line in file_docs:
  docs.append(line.split())

def soundex(word):
  sound_dict = {"b": "1", "c": "2", "d": "3", "f": "1", "g": "2", "j": "2",
      "k": "2", "l": "4", "m": "5", "n": "5", "p": "1", "q": "2", "r": "6", 
      "s": "2", "t": "3", "v": "1", "x": "2", "z": "2"}

  word = re.sub('[\W_]+', '', word)
  fingerprint = str.upper(word[0])

  for letter in word[1:]:
    if str.lower(letter) in sound_dict:
      fingerprint += sound_dict[str.lower(letter)]
    else:
      fingerprint += "-"

  fingerprint = re.sub(r'(11|22|33|44|55|66)', lambda pat: pat.group(1)[0], fingerprint)
  fingerprint = re.sub('-', '', fingerprint)
  return fingerprint[:4].ljust(4, "0")

def set_up_soundex():
  soundex_dict = {} 
  similar_words = {}

  doc_words = []
  for doc in docs:
    doc_words.extend(doc[1:])
  query_words = []
  for query in qrys:
    query_words.extend(query[1:])

  all_words = list(set(doc_words) | set(query_words))

  for word in all_words:
    soundexd = soundex(word)
    soundex_dict[word] = soundexd
    if soundexd not in similar_words:
      similar_words[soundexd] = [word]
    else:
      similar_words[soundexd].append(word)

  return [soundex_dict, similar_words]

def calculate_avg_size(items, item_size):
  total = 0
  for item in items:
    total += len(item) - 1
  
  return float(total) / item_size

def word_in_doc_freq(word_list):
  freq = 0
  for doc in docs:
    for word in word_list:
      if (doc.count(word) > 0):
        freq += 1
        break

  return freq

def calculate_word_doc_freq():
  freq_dict = {}
  doc_words = []
  for doc in docs:
    doc_words.extend(doc[1:])

  unique_words = list(set(doc_words))
  for word in unique_words:
    freq_dict[word] = word_in_doc_freq(similar_words[soundex_lookup[word]])

  return freq_dict 

def get_words(query, doc):
  words = []
  words.extend(query[1:])
  words.extend(doc[1:])

  return list(set(words))

def calculate_value(word, item, avg_item):
  sim_words = similar_words[soundex_lookup[word]]
  item_freq = float(0)

  for sim_word in sim_words:
    item_freq += item.count(sim_word)

  k_item = 1 * (len(item) - 1)
  item_value = item_freq / (item_freq + (k_item/avg_item))
  
  word_freq = float(docs_containing_word[word])
  rarity = math.log(collection_size / word_freq)
  
  return item_value * rarity

def super_calculate_value(words, query, doc):
  calculated_queries = []
  calculated_docs = []
  times = 0
  qsquare = 0
  dsquare = 0

  for word in words:
    calculated_queries.append(calculate_value(word, query, avg_query))
    calculated_docs.append(calculate_value(word, doc, avg_doc))

  for i in range(len(words)):
    times += (calculated_queries[i] * calculated_docs[i])
    qsquare += math.pow(calculated_queries[i], 2)
    dsquare += math.pow(calculated_docs[i], 2)

  return times / (math.sqrt(qsquare) * math.sqrt(dsquare))

[soundex_lookup, similar_words] = set_up_soundex()
collection_size = len(docs)
avg_doc = calculate_avg_size(docs, len(docs))
avg_query = calculate_avg_size(qrys, len(qrys))
docs_containing_word = calculate_word_doc_freq()

for query in qrys:
  print query[0]
  for doc in docs:

    words = get_words(query, doc) 
    cosine = super_calculate_value(words, query, doc)

    if (cosine != 0):
      file_top.write("{0} 0 {1} 0 {2} 0\n".format(query[0], doc[0], cosine))  
      
file_top.close()

