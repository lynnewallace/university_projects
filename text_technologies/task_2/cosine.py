import math

file_docs = open('./docs.txt', 'r')
file_qrys = open('./qrys.txt', 'r')
file_top = open('./cosine.top', 'w')

qrys = []
for line in file_qrys:
  qrys.append(line.split())

docs = []
for line in file_docs:
  docs.append(line.split())

def calculate_avg_size(items, item_size):
  total = 0
  for item in items:
    total += len(item) - 1
  
  return float(total) / item_size

def word_in_doc_freq(word):
  freq = 0
  for doc in docs:
    if (doc.count(word) > 0):
      freq += 1

  return freq

def calculate_word_doc_freq():
  freq_dict = {}
  doc_words = []
  for doc in docs:
    doc_words.extend(doc[1:])

  unique_words = list(set(doc_words))
  for word in unique_words:
    freq_dict[word] = word_in_doc_freq(word)

  return freq_dict 

def get_words(query, doc):
  words = []
  words.extend(query[1:])
  words.extend(doc[1:])

  return list(set(words))

def calculate_value(word, item, avg_item):
  
  item_freq = float(item.count(word))
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

