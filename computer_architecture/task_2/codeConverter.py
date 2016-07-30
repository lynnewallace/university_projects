#s0829961
#codeConverter.py
#takes in arguments - cache configurations, size of n
#outputs cache configuration and accesses of unfused and fused 
#loops up to n into unfused.txt and fused.txt respectively

import sys

class CodeConverter:
    
    #writes out accesses of unfused loop up to n into unfused.txt
    def writeToUnfusedFile(self, n, unfusedFile):
        #first loop
        i=0
        while(i<n):
            j=0
            while(j<n):
                #calculates a[i][j], b[i][j] and c[i][j]
                a = n*i + j
                b = n*n + n*i + j
                c = 2*n*n + n*i + j
                #writes accesses needed for a[i][j] = 1/b[i][j] * c[i][j]
                unfusedFile.write('l {0}{1}'.format(b, '\n'))
                unfusedFile.write('l {0}{1}'.format(c, '\n')) 
                unfusedFile.write('s {0}{1}'.format(a, '\n'))
                j +=1
            i += 1
		
        #second loop
        i=0
        while(i<n):
            j=0
            while(j<n):
                #calculates a[i][j], c[i][j] and d[i][j]
                a = n*i + j
                c = 2*n*n + n*i + j
                d = 3*n*n + n*i + j
                #writes accesses needed for d[i][j] = a[i][j] + c[i][j]
                unfusedFile.write('l {0}{1}'.format(a, '\n'))
                unfusedFile.write('l {0}{1}'.format(c, '\n'))
                unfusedFile.write('s {0}{1}'.format(d, '\n'))
                j +=1
            i += 1
        
        #writes out command to print out hit rate
        unfusedFile.write('h')
    
    #writes out accesses of fused loop up to n into fused.txt			
    def writeToFusedFile(self, n, fusedFile):	
        i=0
        while(i<n):
            j=0
            while(j<n):
                #calculates a[i][j], b[i][j], c[i][j] and d[i][j]
                a = n*i + j
                b = n*n + n*i + j
                c = 2*n*n + n*i + j
                d = 3*n*n + n*i + j
                #writes accesses needed for a[i][j] = 1/b[i][j] * c[i][j]
                fusedFile.write('l {0}{1}'.format(b, '\n'))
                fusedFile.write('l {0}{1}'.format(c, '\n'))
                fusedFile.write('s {0}{1}'.format(a, '\n'))
                #writes accesses needed for d[i][j] = a[i][j] + c[i][j]
                fusedFile.write('l {0}{1}'.format(a, '\n'))
                fusedFile.write('l {0}{1}'.format(c, '\n'))
                fusedFile.write('s {0}{1}'.format(d, '\n'))
                j +=1
            i += 1
		
        #writes out command to print out hit rate
        fusedFile.write('h')
            
    #initializes files and calls writing methods           
    def convert(self, arguments):
        #sanitize
        for i in range(0,5):
            # sanitize - make sure all arguments are ints
            try:
                int(arguments[i])
            except ValueError:
                print "codeConverter.py: Arguments provided for convert method are not all integers"
                sys.exit(2)
            # sanitize - make sure all values are positive
            if(int(arguments[i])<0):
                print "codeConverter.py: Arguments provided for convert method must not be negative"
                sys.exit(2)
            #sanitize - make sure all variables except block eviction are over zero
            if(i!=3):
                if(int(arguments[i])<1):
                    print "codeConverter.py: All arguments except block eviction must be positive"
                    sys.exit(2)
                #sanitize - make sure block eviction argument is 0 or 1
            else:
                if((int(arguments[i])>1) or (int(arguments[i])<0)):
                    print "codeConverter.py: Block eviction mode argument can only be 0 or 1"
                    sys.exit(2)

        #create files to be written to
        unfusedFile = open('unfused.txt', 'w')
        fusedFile = open('fused.txt', 'w')
        
        #write out the first 4 arguments to both files
        for i in range(0, 4):
            unfusedFile.write(arguments[i])
            unfusedFile.write('\n')
            fusedFile.write(arguments[i])
            fusedFile.write('\n')
        
        #get n and call writing functions for each file
        n = int(arguments[4])
        self.writeToUnfusedFile(n, unfusedFile)
        self.writeToFusedFile(n, fusedFile)