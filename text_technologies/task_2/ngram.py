import math

file_docs = open('./docs.txt', 'r')
file_qrys = open('./qrys.txt', 'r')
file_top = open('./ngram5.top', 'w')

qrys = []
for line in file_qrys:
  qrys.append(line.split())

docs = []
for line in file_docs:
  docs.append(line.split())

def ngrams(word, n):
  if len(word) < n:
    return [word]

  results = []
  for i in range(len(word)):
    for j in xrange(i+n, min(len(word), i+n)+1):
      results.append(word[i:j])

  return results

def calculate_avg_doc_size():
  all_docs = 0
  for doc in docs:
    all_docs += len(doc) - 1

  return float(all_docs) / collection_size

def check_doc_for_ngrams(doc, word_list):
  for word in word_list:
    for d in doc:
      if word in d:
        return 1

  return 0

def word_in_doc_freq(docs, word_list):
  freq = 0
  for doc in docs:
    freq += check_doc_for_ngrams(doc, word_list)                

  return freq

def calculate_word_doc_freq():
  freq_dict = {}
  doc_words = []
  for doc in docs:
    doc_words.extend(doc[1:])

  unique_words = list(set(doc_words))
  for word in unique_words:
    freq_dict[word] = word_in_doc_freq(docs, ngrams(word, n_value))

  return freq_dict 

def get_words(query, doc):
  words = []
  words.extend(query[1:])
  words.extend(doc[1:])

  return list(set(words))

def calculate_value(word, query, doc):
  k_doc = 1 * len(doc)
  ngram_collection = ngrams(word, n_value)
  query_freq = float(0)
  doc_freq = float(0)
  
  for ngram in ngram_collection:
    for q in query:
      if ngram in q:
        query_freq += 1
        query.remove(q)
 
    for d in doc:
     if ngram in d:
       doc_freq += 1
       doc.remove(d)

  doc_value = doc_freq / (doc_freq + (k_doc/avg_doc))
  
  word_freq = float(docs_containing_word[word])
  rarity = math.log(collection_size / word_freq)
  
  return query_freq * doc_value * rarity

n_value = 5
collection_size = len(docs)
avg_doc = calculate_avg_doc_size()
docs_containing_word = calculate_word_doc_freq()

for query in qrys:
  print query[0]
  for doc in docs:

    weighted_sum = 0
    words = get_words(query, doc) 

    for word in words:
      weighted_sum += calculate_value(word, query[1:], doc[1:])

    if (weighted_sum != 0):
      file_top.write("{0} 0 {1} 0 {2} 0\n".format(query[0], doc[0], weighted_sum))  
      
file_top.close()
