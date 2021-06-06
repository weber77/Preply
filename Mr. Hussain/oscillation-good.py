from pylab import *

def initialize():
    global x, y, xresult, yresult
    x = 0.2
    y = 1.
    xresult = [x]
    yresult = [y]

def observe():
    global x, y, xresult, yresult
    xresult.append(x)
    yresult.append(y)
    
def update():
    global x, y, xresult, yresult
    nextX = 0.5 * x + y
    nextY = -0.5 * x + y

    x, y = nextX, nextY
    
initialize()

for t in range(30):
    update()
    observe()

plot(xresult, 'b--')
plot(yresult, 'g--')
plot(xresult, yresult)

show()