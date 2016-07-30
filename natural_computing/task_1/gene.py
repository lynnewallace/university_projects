class Gene:
  #set up gene object with chromosone and scores
  def __init__(self, chromosone):
    self.chromosone = chromosone
    self.score = 0
    self.fightcount = 0

  #use chromosone to get initial history
  def resethistory(self):
    self.youhistory = self.chromosone[len(self.chromosone)-6:len(self.chromosone)-3]
    self.opphistory = self.chromosone[len(self.chromosone)-3:]

  #update history by pushing first move out and adding new move to the end
  def updatehistory(self, youlastmove, opplastmove):
    self.youhistory = self.youhistory[1:] + youlastmove
    self.opphistory = self.opphistory[1:] + opplastmove
 
  #get fight move using current history
  def fightmove(self):
    return self.chromosone[int(self.youhistory + self.opphistory, 2)]

  def resetscore(self):
    self.score = 0

  def addtoscore(self, points):
    self.score = self.score + points

  def resetfightcount(self):
    self.fightcount = 0

  def updatefightcount(self):
    self.fightcount = self.fightcount + 1

  def updatefitnessscore(self, fitness):
    self.fitness = fitness
