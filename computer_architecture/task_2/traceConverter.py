#s0829961
#traceConverter.py
#takes in argument - filename
#collects information about the cache configuration and creates a list of traces
#this is given to the cache simulator

import collections
import sys

class TraceConverter:
	
    def converter(self,filename):
        #create tuples to hold cache and access information
        SystemOptions = collections.namedtuple('System', 'block_amount, word_amount, associativity, lru')
        Load = collections.namedtuple('Load', 'name, location, verbose')
        Store = collections.namedtuple('Store', 'name, location, verbose')
		
        #flag for signifying if access should be verbose
        isVerbose = False
        #open the trace file to be read
        traceFile = open(filename, 'r')
		
        #read in cache configuration
        systemItems = []
        for i in range(0, 4):
            line = traceFile.readline()
            systemItems.append(int(line.split()[0]))
        #sanitize - associativity should never be larger than number of blocks
        if(systemItems[2] > systemItems[0]):
            print "traceConverter.py: associativity is larger than cache size"
            sys.exit(2)
        #create tuple for cache config
        systemConfig = SystemOptions._make(systemItems)
		
        cacheQueue = []
        #read in remaining lines
        commands = traceFile.readlines()
        #split lines into lists of words to collect command
        for line in commands:
            words = line.split()
			#toggles verbose
            if(words[0] == 'v'):
                isVerbose = not isVerbose
                continue
            #creates a load access tuple with info supplied
            if(words[0] == 'l'):
                loadItem = ('load',int(words[1]),isVerbose)
                cacheItem = Load._make(loadItem)
                cacheQueue.append(cacheItem)
                continue
            #creates a store access tuple with info supplied
            if(words[0] == 's'):
                storeItem = ('store',int(words[1]),isVerbose)
                cacheItem = Store._make(storeItem)
                cacheQueue.append(cacheItem)
                continue
            #creates a print command
            if(words[0] == 'p'):
                cacheQueue.append('Print contents')
                continue
            #creates a hit rate command
            if(words[0] == 'h'):
                cacheQueue.append('Print hit rate')
                continue
            #sanitize - incorrect letters will flag error
            print"traceConverter.py: Command not recognized"
            sys.exit(2)
        #returns tuple with cache config and list of access + info
        return (systemConfig, cacheQueue)