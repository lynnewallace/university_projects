#s0829961
#cacheSimulator.py
#takes in arguments - cache configurations, size of n, input trace filename
#simulates cache using accesses from supplied file
#supports any set associativity, different block replacement schemes
#prints out hitrate and cache contents when commanded to

from traceConverter import TraceConverter
from codeConverter import CodeConverter
import sys
import random

class CacheSimulator:
    #prints out contents of cache
    def printer(self,details, blocksize):
        print '\n'
        set = 0
        block = 0
        #sets
        for i in range(0, len(details)):
            if(len(details)!=blocksize):
                print '---Set {0}---'.format(set)
            #blocks
            for j in range(0, len(details[i])):
                #empty block
                if(details[i][j]=='empty'):
                    print 'Block {0}: {1}'.format(block,details[i][j])
                #block with items in it
                else:
                    extras = '|'
                    for k in range(0, len(details[i][j])):
                        extras += str(details[i][j][k])
                        extras += '|'
                    print 'Block {0}: {1}'.format(block,extras)
                block += 1
            set += 1
        print '\n'
		

    #if block is in the set return the position else -1
    def checkForMatches(self,blocks, startOfBlock):
        for i in range(0, len(blocks)):
            x = blocks[i][0]
            if(x == startOfBlock):
                return i		
        return -1
	
	#picks a random number between 0 and the number of blocks in set
    def randomBlock(self,blocksInSet):
        return random.randint(0, blocksInSet-1)
		
    #sorts block positions by most recent use
    #return position of least recently used
    def lruBlock(self,z,blocksInSet):
        y = range(0, blocksInSet)
        history = zip(z, y)
        history.sort()
        return history[0][1]
	#main code	
    def start(self, args):	
        #if there are over 2 arguments call the trace generation function
        offset = 0
        if(len(args)>2):
            offset = 5
            codeConverter = CodeConverter()
            parameters = [args[0],args[1],args[2],args[3],args[4]] 
            codeConverter.convert(parameters)
        #convert file to list of accesses and cache config 
        traceConvert = TraceConverter()
        data = traceConvert.converter(args[0 + offset])
        systemData = data[0]
        traceData = data[1]

        #initialize variables
        cacheBlocks = []
        cacheBlockCount = []
        hitrate = 0
        missrate = 0
        oldset = 0
        noOfSets = systemData.block_amount/systemData.associativity
        if(systemData.lru==0):
            mode = 'random'
        else:
            mode = 'lru'
        #sanitize - check if blocks can be split into sets equally
        if(systemData.block_amount%systemData.associativity !=0):
            print "Blocks cannot be split into equal sets"
            sys.exit(2)
        
        #print details about system
        print '\nSystem details:'
        print 'Number of blocks: {0}'.format(systemData.block_amount)
        print 'Number of words in a block: {0}'.format(systemData.word_amount)
        print 'Set associativity: {0}-way'.format(systemData.associativity)
        print 'Block eviction: {0}'.format(mode)

        #create structure for cache and counter
        for i in range (0,noOfSets):
            cacheBlocks.append([])
            cacheBlockCount.append([])
        for i in range(0,noOfSets):
            for j in range(0,systemData.associativity):
                cacheBlocks[i].append('empty')
                cacheBlockCount[i].append(0)
        
        #run through accesses
        for i in range(0, len(traceData)):
            #hit rate
            if(traceData[i]=='Print hit rate'):
                print 'Hit rate is {0} out of {1} = {2}% so far\n'.format(hitrate, (hitrate + missrate), float(hitrate*100)/float(hitrate+missrate))
            #cache contents
            elif(traceData[i]=='Print contents'):
                pass
                #self.printer(cacheBlocks,systemData.block_amount)
            #access
            else:
                #calculate first address in block and which set to put it in
                startOfBlock = traceData[i].location/systemData.word_amount * systemData.word_amount
                setToPutIn = (startOfBlock/systemData.word_amount) % noOfSets
                #check if block is already in cache
                checker = self.checkForMatches(cacheBlocks[setToPutIn], startOfBlock)
                #miss
                if(checker == -1):
                    status = 'miss'
                    missrate += 1
                    #calculate which block replace
                    if(mode == 'random'):
                        ranblock = self.randomBlock(systemData.associativity)
                    else:
                        ranblock = self.lruBlock(cacheBlockCount[setToPutIn],systemData.associativity)
                    #hold old data for printing
                    evictee = cacheBlocks[setToPutIn][ranblock]
                    oldset = setToPutIn
                    #put new contents into block and update counter
                    cacheBlocks[setToPutIn][ranblock] = range(startOfBlock, startOfBlock + systemData.word_amount)
                    cacheBlockCount[oldset][ranblock] = hitrate + missrate
                #hit
                else: 
                    status = 'hit'
                    hitrate +=1
                    #update counter
                    cacheBlockCount[oldset][checker] = hitrate + missrate
                #when access is verbose
                if(traceData[i].verbose==True):
                    print 'A {0} to address {1} in set {2} and was a {3}'.format(traceData[i].name,traceData[i].location,setToPutIn,status)
                    if(checker == -1):
                        #cold miss
                        if(evictee=='empty'):
                            print 'cold miss'
                        #evicted mode
                        else:
                            print 'evict {0} using {1} mode'.format(evictee, mode)
        #print out final contents of cache
        #self.printer(cacheBlocks,systemData.block_amount)
        return float(hitrate*100)/float(hitrate+missrate)
#initialize simulator    
sim = CacheSimulator()
#run trace generation and simulator
if(len(sys.argv)==8):
    sim.start([sys.argv[1],sys.argv[2],sys.argv[3],sys.argv[4],sys.argv[5],sys.argv[6]])
#run simulator
elif(len(sys.argv)==2):
    sim.start([sys.argv[1]])
