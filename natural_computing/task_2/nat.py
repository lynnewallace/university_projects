import random
import time
om = 0.6
globalbest = (101,101)
n = 2000

def createparticles():
  particles = []
  global globalbest

  for i in range(n):
    position = (random.randint(-100, 100),random.randint(-100, 100))
    velocity = (random.randint(-30, 30),random.randint(-30, 30))
    localbest = position
    
    if (fitness(position) < fitness(globalbest)):
      globalbest = position
    
    particles.append([position, velocity, localbest])
  return particles

def updateparticles(al1, al2, particles):
  global globalbest
 
  for i in range(n):
    oldpos = particles[i][0]
    oldvel = particles[i][1]
    oldloc = particles[i][2]
    r1 = random.random()
    r2 = random.random()    

    newvelx = om*oldvel[0] + al1*r1*(oldloc[0]-oldpos[0]) + al2*r2*(globalbest[0]-oldpos[0])
    newvely = om*oldvel[1] + al1*r1*(oldloc[1]-oldpos[1]) + al2*r2*(globalbest[1]-oldpos[1])
    newvel = (newvelx, newvely)
    newpos = (oldpos[0]+newvel[0], oldpos[1]+newvel[1])
   
    newfitness = fitness(newpos) 
    if (newfitness < fitness(oldloc)):   
      particles[i][2] = newpos
      if (newfitness < fitness(globalbest)):
        globalbest = newpos

    particles[i][0] = newpos
    particles[i][1] = newvel
  return particles

def fitness(particlepos):
  return particlepos[0]**2 + particlepos[1]**2

def getscatterpoints(values): 
  x = []
  y = []
  for i in range(n):
    x.append(values[i][0][0])
    y.append(values[i][0][1])
  return x,y

def plotstuff(x,y):
  fig = plt.figure(1)
  a = fig.add_subplot(111)
  a.axis([-10,10,-10,10])
  a.locator_params(nbins=20)  
  a.scatter(x,y)
  a.set_xlabel('x', fontsize=15)
  a.set_ylabel('y', fontsize=15)
  a.set_title('Swarm')
  a.grid(True)
  a.axhline(linewidth=1, color='r')
  a.axvline(linewidth=1, color='r')
  fig.canvas.draw()

def q2(al1, al2):
    particles = createparticles()
    points = getscatterpoints(particles)
 
    for i in range(100):
      particles = updateparticles(al1, al2, particles)
      points = getscatterpoints(particles)
       
      plt.clf()
      plotstuff(points[0], points[1])

#set up plotting
import matplotlib
matplotlib.use('TKAgg')
import matplotlib.pyplot as plt
plt.figure(1)
plt.show()
