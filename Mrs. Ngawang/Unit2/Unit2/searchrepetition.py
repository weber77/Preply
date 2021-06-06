import sys

# Function to verify program is ready to run
def init():
    global path, pattern, position
    # Ensure user enters all 3 arguments
    if len(sys.argv) != 4 :
        print("Program requires exaclty 3 arguments")
        exit()

    pattern = sys.argv[1]
    position = int(sys.argv[2])
    path = sys.argv[3]


def readData():
    global codons 
    codons = []
    # attempt to read file
    try:
        # open file
        f = open(path, "r") 
        
        # read all lines into a single string eliminating space and removing \n
        lines = []
        for line in f:
            lines.append(line.rstrip())

        # Check if file contain characters other than n,s,w,e
        if any( c not in 'acgt' for line in lines for c in line):
            print("File contains undesired character.")
            exit()

        # Convert file string into list

        for i  in range(len(lines)):
            if len(lines[i]) % 3 != 0:
                print("\n*******************************************")
                print("Line \"" + str(i) + "\" condon sequence not multiple of 3\nExiting...")
                print("*******************************************\n")
                exit()

        line_codon = []
        
        n =3
        for line in lines:
            [line[i:i+n] for i in range(0, len(line), n)]
            codons.append([line[i:i+n] for i in range(0, len(line), n)])
            

        # closing file safely
        f.close()

    except IOError:
        print("\n**************************************")
        print("File \"" + path + "\" not found or can't be read.")
        print("**************************************\n")
        exit()


def count_repeatition():
    found = False
    count = 0
    for line in codons:
        for j in range(len(line)):
            if line[j] == pattern and (j+1)%position == 0:
                count += 1
                found = True
        if count >0:
            print("String " + str(line))
            print("Pattern is repeated: " + str(count))
            count = 0
    
    if not found:
        print("Repetition of codon ccc every 4th position not found.")

if __name__ == '__main__':
    init()
    readData()
    count_repeatition()