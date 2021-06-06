import sys



# Function to verify program is ready to run
def init():
    global path, width, length
    # Ensure user enters all 3 arguments
    if len(sys.argv) != 4 :
        print("Program requires exaclty 3 arguments")

    width = int(sys.argv[1])
    length = int(sys.argv[2])
    path = sys.argv[3]

    # Validate sides are integers
    if not type(length) or not type(width) is int:
        raise TypeError("Only integers are allowed for first 2 arguments")
    
    # ensure size of town greater than 10
    if length <= 10 or width <= 10:
        print("Minimum length and width are 10 units.")

    # ensure town size sides are odd units
    if length % 2 == 0:
        length -= 1
    if width % 2 == 0:
        width -= 1

def readData():
    global pathSeq
    # attempt to read file
    try:
        # open file
        f = open(path, "r") 
        
        # read all lines into a single string eliminating space and removing \n
        string = ""
        for line in f:
            string += line.rstrip().replace(" ", "")

        # Check if file contain characters other than n,s,w,e
        if any( c not in 'nwse' for c in string):
            print("File contains undesired character.")
            exit()

        # Convert file string into list
        pathSeq = list(string) 

        # closing file safely
        f.close()
    except IOError:
        print("file " + path + " not found or can't be read.")
        exit()
    
def move():
    
    global position, counter
    counter = 0

    # define city grid origin
    center  = [ length//2 , width//2]
    
    # list of 5 tiles forming the gate
    gate = [[length-1, (width//2)-2],
            [length-1, (width//2)-1],
            [length-1, (width//2)  ],
            [length-1, (width//2)+1],
            [length-1, (width//2)+2]]
    

    position = center

    for i in pathSeq:
        if i == "n":
            moveNorth()
        elif i == "s":
            moveSouth()
        elif i == "e":
            moveEast()
        else:
            moveWest()

        checkGate(gate)
        if position == center:
            counter += 1
    print("End of walk. Didn't reach gate nor wall. Pass through origin : " + str(counter))
    exit()
    
def checkGate(gate):
    global counter
    if position in gate:
        print("Gate reached. Pass through origin : " + str(counter))
        exit()

def moveNorth():
    global city, position, counter
    # moving north implies j = j and i = i-1
    if position[1] > 0:
        position = [position[0], position[1] - 1]
    else:
        print("Northern Wall reached. Pass through origin : " + str(counter))
        exit()

def moveSouth():
    global city, position, counter
    # moving south implies j = j and i = i+1
    if position[1] < width:
        position = [position[0], position[1] + 1] 
    else:
        print("Southern Wall reached. Pass through origin : " + str(counter))
        exit()

def moveWest():
    global city, position, counter 
    # moving west implies j = j-1 and i = i
    if position[0] > 0:
        position = [position[0] - 1 , position[1]] 
    else:
        print("Western Wall reached. Pass through origin : " + str(counter))
        exit()

def moveEast():
    global city, position, counter
    # moving east implies j = j + 1 and i = i
    if position[1] < width:
        position = [position[0]  + 1, position[1]] 
    else:
        print("East Wall reached. Pass through origin : " + str(counter))
        exit()


    
if __name__ == '__main__':
    init()
    readData()
    move()
