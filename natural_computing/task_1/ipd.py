import random
from gene import Gene
from numpy import max, var, mean, array

crossoverrate = (95,5)
mutationrate = (1,999)
generationsize = 10
sucker = 0
defect = 1
cooperate = 3
traitor = 5

#returns list of $generationsize genes with randomized chromosones
def generatepopulation():
  population = []
  for _ in range(generationsize):
    population.append(Gene(randomchromosone()))
  return population

#fight genes against each other
#update history and score of genes playing
def fight(fighter1, fighter2):
  fightmove1 = fighter1.fightmove() 
  fightmove2 = fighter2.fightmove()
  fighter1.updatehistory(fightmove1, fightmove2)
  fighter2.updatehistory(fightmove2, fightmove1)  
 
  #CC
  if(fightmove1 == '1'):
    if(fightmove2 == '1'):
      fighter1.addtoscore(cooperate)
      fighter2.addtoscore(cooperate)
    #CD
    else:
      fighter1.addtoscore(sucker)
      fighter2.addtoscore(traitor)
  #DC
  elif(fightmove2 == '1'):
    fighter1.addtoscore(traitor)
    fighter2.addtoscore(sucker)
  #DD
  else: 
    fighter1.addtoscore(defect)
    fighter2.addtoscore(defect)

  fighter1.updatefightcount()
  fighter2.updatefightcount()

#genes play all others many times to get its fitness
def tournament(population):
  popfit = [] 
  for i in population:
    i.resetscore()
    i.resetfightcount()
    for j in population:
      if(i != j):
        i.resethistory()
        j.resethistory()
        for _ in range(50):
          fight(i,j) 
    i.updatefitnessscore(float(i.score)/float(i.fightcount)/float(5))
    popfit.append((i.fitness, i))
  return popfit

#select best genes and reproduce
def elitism(population):
  population.sort(reverse=True)
  tophalf = []
  for _ in range(generationsize/2):
    tophalf.append(population[_][1]) 

  newpopulation = []
  for _ in range(generationsize/4):
    parent1 = random.choice(tophalf)
    parent2 = random.choice(tophalf)
    children = crossover(parent1.chromosone, parent2.chromosone)
    newpopulation.append(Gene(mutation(children[0])))
    newpopulation.append(Gene(mutation(children[1])))

  return tophalf + newpopulation

#take 2 parents and cross them over to return 2 children
def crossover(parent1, parent2):
  if(randpercentage(crossoverrate) == True):
    splitplace = random.randint(1,len(parent1))
    child1 = parent1[:splitplace] + parent2[splitplace:]
    child2 = parent2[:splitplace] + parent1[splitplace:]
    return (child1, child2)
  return (parent1, parent2)

#mutate gene based on probability
def mutation(chromosone):
  newchromosone = ''
  for i in chromosone:
    if(randpercentage(mutationrate) == True):
      newchromosone = newchromosone + flipbit(i)
    else:
      newchromosone = newchromosone + i
  return newchromosone

#make a random 70 string chromosone
def randomchromosone():
  chromosone = ''
  for _ in range(70):
    chromosone = chromosone + str(random.randint(0,1))
  return chromosone

#returns True or False which are weighted by the distribution
def randpercentage(distribution):
  values = (1,0)
  choices = [v for v, d in zip(values, distribution) for _ in range(d)]
  return bool(random.choice(choices))

#change '0' to '1' and '1' to '0'
def flipbit(value):
  if(value == '1'):
    return '0'
  return '1'

def teststuff():
  x = generatepopulation()
  avgfit = []
  topfit = []
  varfit = []
  for i in range(100):
    fit = tournament(x)
    x = elitism(fit)
    testing = []
    for j in fit:
      testing.append(j[0])
    testing = array(testing)
    avgfit.append(testing.mean())
    topfit.append(testing.max())
    varfit.append(testing.var())
    print 'Generation {0}'.format(i)
  return (x, avgfit, topfit, varfit)

def graphstuff(x):
  plt.plot(range(len(x)), x)
  plt.show()

import matplotlib
matplotlib.use('TKAgg')
import matplotlib.pyplot as plt
