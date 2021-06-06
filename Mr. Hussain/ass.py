from pylab import *

a = 0.05
K = 500

def initialize():
    global x, result
    x = 10.
    result = [x]

def observe():
    global x, result
    result.append(x)

def update():
    global x, result
    x = -( ((a-1) * x/K) + a ) * x
    # initialize()

initialize()
for t in range(30):
    update()
    observe()

print(result)

plot(result)
show()

# f(x) = -( (a-1) * x/K ) * x