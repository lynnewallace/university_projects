import math

file_docs = open('./docs.txt', 'r')
file_qrys = open('./qrys.txt', 'r')
file_top = open('./tfidf.top', 'w')

qrys = []
docs = []

# read in queries and documents
def populate_lists():
  for line in file_qrys:
    qrys.append(line.split())

  for line in file_docs:
    docs.append(line.split())

# average words in document
def calculate_avg_doc_size():
  all_docs = 0

  for doc in docs:
    # dont include document id
    all_docs += len(doc) - 1

  return float(all_docs) / collection_size

# number of documents containing the word
def word_in_doc_freq(word):
  freq = 0
  for doc in docs:
    # increment if doc has word in it
    if (doc.count(word) > 0):
      freq += 1

  return freq

# document frequency for each word 
def calculate_word_doc_freq():
  freq_dict = {}
  doc_words = []
  # all words in all docs
  for doc in docs:
    doc_words.extend(doc[1:])

  unique_words = list(set(doc_words))
  # calculate document frequency for each unique word
  for word in unique_words:
    freq_dict[word] = word_in_doc_freq(word)

  return freq_dict 

# get unique words in query and document
def get_words(query, doc):
  words = []
  words.extend(query[1:])
  words.extend(doc[1:])

  return list(set(words))

# calculate weighted value
def calculate_value(word, query, doc):
  # times word appears in query
  query_freq = query.count(word)
  
  # times word appears in doc
  doc_freq = float(doc.count(word))
  # dont include document id
  k_doc = 2 * (len(doc) - 1)
  doc_value = doc_freq / (doc_freq + (k_doc/avg_doc))
  
  word_freq = float(docs_containing_word[word])
  rarity = math.log(collection_size / word_freq)
  
  return query_freq * doc_value * rarity

# populate with queries and docs
populate_lists()
collection_size = len(docs)
avg_doc = calculate_avg_doc_size()
# get document frequency for each word
docs_containing_word = calculate_word_doc_freq()

for query in qrys:
  print query[0]
  for doc in docs:

    weighted_sum = 0
    words = get_words(query, doc) 

    # calculate weighted sum
    for word in words:
      weighted_sum += calculate_value(word, query, doc)

    # if there is similarity
    if (weighted_sum != 0):
      # write in specified format
      file_top.write("{0} 0 {1} 0 {2} 0\n".format(query[0], doc[0], weighted_sum))  
      
# close .top file
file_top.close()
