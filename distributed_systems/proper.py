import sys
from collections import namedtuple 

# named tuples to hold the link and command information
Link = namedtuple('Link', 'left right')
Command = namedtuple('Command', 'command node table')

# structures to hold the input data
nodes = {}
links = []
commands = []

# object to hold node information
class Node:
  
  def __init__(self, name, local_addresses):
    self.name = name
    self.local_addresses = local_addresses
    self.table = {}
    # set up table
    for address in local_addresses:
      self.table[address] = [address, 'local', 0]
    
  # update table using rip algorithm 
  def update_table(self, received_name, received_table):
    # copy old version
    current_config = self.table.copy()
    print "receive {0} {1} {2}".format(received_name, self.name, table_format(received_table))

    for row in received_table:
      data = received_table[row]

      # if address is not known, add to table
      if row not in self.table:
        self.table[row] = [data[0], received_name, data[2] + 1]
      
      # if cost is better than current, add to table
      if data[2] + 1 < self.table[row][2]:
        self.table[row] = [data[0], received_name, data[2] + 1] 

      # does address go through received link
      if self.table[row][1] == received_name:
        
        # update if cost has changed
        if self.table[row][2] - 1 != data[2]:
          self.table[row] = [data[0], received_name, data[2] + 1]
         
    # add send command to queue if anything has changed
    change = [k for k in self.table if k not in current_config]
    if change != []:
      commands.append(Command('send', self.name, self.table.copy()))

# take each line in input file and get info 
def parse_config(filename):
  for line in open(filename, 'r'):
    config = line.split()
    
    # node
    if config[0] == 'node':
      # get name and local addresses
      nodes[config[1]] = Node(config[1], [int(x) for x in config[2:]])
    # link
    if config[0] == 'link':
      # get left and right node names
      links.append(Link(config[1], config[2]))
    # command
    if config[0] == 'send':
      # get node name and its table
      commands.append(Command('send', config[1], nodes[config[1]].table))

def get_neighbours(node):
  neighbours = []

  # if node is referenced in a link add the other node to neighbours
  for link in links:
    if link.left == node.name:
      neighbours.append(nodes[link.right])
    if link.right == node.name:
      neighbours.append(nodes[link.left])

  return neighbours

# format table nicely
def table_format(table):
  to_print = ""
  for entry in table.values():
    to_print += "({0}|{1}|{2}) ".format(entry[0], entry[1], entry[2]) 
  
  return to_print

# print all node tables
def print_all():
  for node in nodes:
    print "table {0} {1}".format(node, table_format(nodes[node].table))

def start():
  # while there are still commands
  while len(commands) > 0:
    # take first command in queue
    current_command = commands.pop(0)
    # find link neighbours
    neighbours = get_neighbours(nodes[current_command.node])
    # send table to all neighbours
    for neighbour in neighbours:
      print "send {0} {1} {2}".format(current_command.node, neighbour.name, table_format(current_command.table))
      neighbour.update_table(current_command.node, current_command.table)
        
  # print final router information tables
  print_all()    

# parse the given input file
parse_config(sys.argv[1])
# kick start 
start()





#                         ======== INPUT ====
#
# This is the main file
# Takes the file name of the input file as an argument on the command line
# Usage: python proper.py [filename]
#
#                         ======= OUTPUT ====
#
# Output is written to stdout
#
#                         ==== QUESTIONS ====                           
# 
# Q1 : When a process p1 updates its table in response to a table received
# from process p2, is it necessary that process p1 sends its updated table
# back to process p2? Explain the reasoning behind your answer.
#
# [simulation in q1.py]
# A1 : It is necessary for the updated table to be sent back in order for the
# algorithm given to converge to the correct configuration.
# Lets say that p1 only has 1 link, which is to p2, if there is no 'send p1' 
# command in the input file, p1 will never be able to divulge its information
# to the rest of the network. This is because each time p1 receives a table
# it cannot respond with its own updated table thus its own information 
# is disregarded.
# This can be worked around with the periodic sending of tables which would
# allow p1s table information to be taken into account.
#
#
# Q2: Whether you answered yes or no to the first part, does requiring p1
# to return its updated table to p2 increase or decrease the number of
# events required for the algorithm to converge, or does it depend on the
# network and/or ordering of events? Try to justify your answer with
# logic and/or statistics from your simulator.
#
# A2 : Requiring p1 to return its updated table sees an increase in the number 
# of events required for a table to converge (although this may not be a fully
# correct table as discussed above). Below are some comparisons in the number of
# events needed to converge for different networks:
#
# Required | Not required 
#   111    |     65
#   125    |    135
#   145    |     99

