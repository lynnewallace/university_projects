import sys
from collections import namedtuple 

# named tuples to hold the link and command information
Link = namedtuple('Link', 'left right')
Command = namedtuple('Command', 'command node table block')

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
      commands.append(Command('send', self.name, self.table.copy(), received_name))

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
      commands.append(Command('send', config[1], nodes[config[1]].table, ''))

def get_neighbours(node, block):
  neighbours = []

  # if node is referenced in a link add the other node to neighbours
  # unless its blocked 
  for link in links:
    if link.left == node.name and block != link.right:
      neighbours.append(nodes[link.right])
    if link.right == node.name and block != link.left:
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
    neighbours = get_neighbours(nodes[current_command.node], current_command.block)
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
