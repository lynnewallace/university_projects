file_docs = open('./docs.txt', 'r')
file_qrys = open('./qrys.txt', 'r')
file_top = open('./overlap.top', 'w')

qrys = []
docs = []

# read in queries and documents
def populate_lists():
  for line in file_qrys:
    qrys.append(line.split())

  for line in file_docs:
    docs.append(line.split())

# calculate overlapping terms
def overlap(a, b):
  return len(set(a) & set(b))

# populate with queries and docs
populate_lists()

for query in qrys:
  for doc in docs: 
    # calculate overlap score
    score = overlap(query[1:], doc[1:])
    
    # if there is similarity
    if (score != 0):
      # write in specified format
      file_top.write("{0} 0 {1} 0 {2} 0\n".format(query[0], doc[0], score))

# close .top file
file_top.close()
