import operator
import re
import math
from collections import namedtuple

# files to be written to
file_hubs = open('./hubs.txt', 'w')
file_auth = open('./auth.txt', 'w')
file_pr = open('./pr.txt', 'w')
file_graph = open('./graph.dot', 'w')

# structure to hold details of email links between people
people = {}
Person = namedtuple('Person', 'inlinks outlinks')

# lambda for pagerank
lambd = 0.8

# write output to appropriate file
def write_out(filename, top_list):
  for entry in top_list:
    # cut to 8 decimal digits for score
    filename.write("{0} {1}\n".format(str(entry[1])[:10], entry[0]))

# update dictionary with new content
def modify_dict(person, link_list):
  if person in link_list:
    link_list[person] += 1
  else:
    link_list[person] = 1

  return link_list

def parse_file():
  for line in open('./graph.txt', 'r'):
    email = line.split()
    sender = email[1]
    recipient = email[2]

    # no emails to oneself
    if sender != recipient:
      # add namedtuple if not in dict
      if sender not in people:
        people[sender] = Person({}, {recipient: 1})
      # update namedtuple if in dict
      else:
        new_outlinks = modify_dict(recipient, people[sender].outlinks)
        people[sender]._replace(outlinks = new_outlinks)

      # add namedtuple if not in dict
      if recipient not in people:
        people[recipient] = Person({sender: 1}, {})
      # update namedtuple if in dict
      else:
        new_inlinks = modify_dict(sender, people[recipient].inlinks)
        people[recipient]._replace(inlinks = new_inlinks)

def get_rank(ranks, person, s):
  x = (1 - lambd + (lambd * s)) / len(people)
  y = 0.0

  in_links = person.inlinks
  
  for link in in_links:
    # number of score sharing nodes 
    link_out = sum(people[link].outlinks.values())    
    if link_out > 0:
      # take proportion of score
      y += (ranks[link] * in_links[link]) / link_out
  
  return x + (lambd * y)

def page():  
  page_now = {}
  # initial rank is equal amongst nodes
  initial_rank = 1.0 / len(people)

  # set initial rank for all
  for person in people:
    page_now[person] = initial_rank
    
  # find sink nodes
  sinks = [p for p in people if len(people[p].outlinks) == 0]
  # initial sink score
  s_now = (1.0/len(people)) * len(sinks)
  
  # iterate 10 times
  for i in range(10):

    page_next = {}

    # calculate new sink score  
    s_next = 0.0
    for sink in sinks:
      s_next += get_rank(page_now, people[sink], s_now)

    # calculate new pagerank score
    for person in people:
      page_next[person] = get_rank(page_now, people[person], s_now)

    # update variables for next iteration
    page_now = page_next 
    s_now = s_next

  # get top 10 pagerank scores
  top_pr = sorted(page_now.iteritems(), key=operator.itemgetter(1), reverse=True)[:10]
  # write out scores
  write_out(file_pr, top_pr)

  return page_now

# divide all scores by normalize value
def normalize(norm, scores):
  for score in scores:
    scores[score] = scores[score] / norm

  return scores

def get_scores(update_values, link_type):
  norm = 0.0
  scores = {}

  for person in people:
    score = 0
    # get links
    links = getattr(people[person], link_type)

    for link in links:
      score += update_values[link] * links[link]
    
    scores[person] = score
    # update normalization value
    norm += math.pow(score, 2) 

  norm = math.sqrt(norm)
  return normalize(norm, scores)

def hits():
  hubs = {}
  auth = {}

  # initialize all to 1.0
  for person in people:
    hubs[person] = 1.0
    auth[person] = 1.0

  # iterate 10 times
  for i in range(10):
    
    # calculate hub values
    hubs = get_scores(auth, 'outlinks')
    # calculate authority values
    auth = get_scores(hubs, 'inlinks')

  # get top 10 hub and authority scores
  top_hubs = sorted(hubs.iteritems(), key=operator.itemgetter(1), reverse=True)[:10]
  top_auth = sorted(auth.iteritems(), key=operator.itemgetter(1), reverse=True)[:10]
  # write out scores
  write_out(file_hubs, top_hubs)
  write_out(file_auth, top_auth)

  return [hubs, auth]

def get_keywords(data):
  # words to remove
  remove = ['N/A', 'Employee']
  keywords = []

  for word in data:
    if word not in remove:
      keywords.append(word)

  return keywords

def get_graph_info():
  info = {}

  for line in open('./roles.txt', 'r'):
    data = line.split()

    # get working data
    if len(data) > 2:
      email = data[0]
      keywords = get_keywords(data[3:])
      
      # add if there are keywords
      if len(keywords) != 0:
        info[email] = keywords

  return info

def interesting():
  graph = {}
  # top pagerank people
  top = sorted(x.iteritems(), key=operator.itemgetter(1), reverse=True)[:10]
  # top people on roles.txt list
  on_list = [entry[0] for entry in top if entry[0][:-10] in info.keys()]

  # find the links between these people
  for person in on_list:
    in_links = [(entry, people[person].inlinks[entry]) for entry in on_list if entry in people[person].inlinks.keys()]
    out_links = [(entry, people[person].outlinks[entry]) for entry in on_list if entry in people[person].outlinks.keys()]

    graph[person] = Person(in_links, out_links)
  return graph

def write_links(name, links):
  for link in links:
    file_graph.write("{0} -> {1} [label = \"{2}\"];\n".format(re.sub("['@.']" , '', name), re.sub("['@.']" , '', link[0]), link[1]))

def write_graph():
  top_hubs = sorted(y[0].iteritems(), key=operator.itemgetter(1), reverse=True)[:10]
  hub_names = [x[0] for x in top_hubs]
  top_auth = sorted(y[1].iteritems(), key=operator.itemgetter(1), reverse=True)[:10]
  auth_names = [x[0] for x in top_auth]

  file_graph.write("digraph G {\nnode [shape=record];\n")

  for g in graph:
    color = ""
    if g in hub_names and g in auth_names:
      color = "style=filled, fillcolor=mediumpurple1, "
    elif g in auth_names:
      color = "style=filled, fillcolor=lightblue1, "
    elif g in hub_names:
      color = "style=filled, fillcolor=lightpink, "
 
    file_graph.write("{0} [{1}label=\"{2}|{3}\"];\n".format(re.sub("['@.']" , '', g), color, g[:-10], "".join(info[g[:-10]])))   

  for g in graph:
    write_links(g, graph[g].outlinks)
  
  file_graph.write("}")

# preprocessing
parse_file()

# part 1
x = page()
y = hits()

# part2
info = get_graph_info()
graph = interesting()
write_graph()

# close files
file_hubs.close()
file_auth.close()
file_pr.close()
file_graph.close()
