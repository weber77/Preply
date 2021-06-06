from pylab import *

a = 1.1

def initialize():
    global x, result
    x = 1.
    result = [x]

def observe():
    global x, result
    result.append(x)

def update():
    global x, result
    x = a * x
    # initialize()

initialize()
for t in range(30):
    update()
    observe()

print(result)

plot(result)
show()

# f(x) = a * x