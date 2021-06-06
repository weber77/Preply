import sys


# Function to verify program is ready to run
def init():
    global path
    # Ensure user enters all 3 arguments
    if len(sys.argv) != 2 :
        print("Program requires exaclty 2 arguments")
        exit()

    path = sys.argv[1]

class amino_acid:
    def __init__(self, name, codons, count =0 ):
        self.codons = codons
        self.name = name
        self.count = count

def setAcids():
    global acids
    acids = []
    acids.extend((
        amino_acid("PHE", ['ttt', 'ttc']),
        amino_acid("LEU", ["tta", "ttg"]),
        amino_acid("SER", ["tct","tcc","tca","tcg"]),
        amino_acid("TYR", ["tat,tac"]),
        amino_acid("CYS", ["tgt","tgc"]),
        amino_acid("LEU", ["ctt","ctc","cta","ctg"]),
        amino_acid("PRO", ["cct","ccc","cca","ccg"]),
        amino_acid("HIS", ["cat","cac"]),
        amino_acid("GIN", ["caa","cag"]),
        amino_acid("ARG", ["cgt","cgc","cga","cgg"]),
        amino_acid("ILE", ["att","atc","ata"]),
        amino_acid("MET", ["atg"]),
        amino_acid("THR", ["act","acc","aca","acg"]),
        amino_acid("ASN", ["aat","aac"]),
        amino_acid("LYS", ["aaa","aag"]),
        amino_acid("SER", ["agt","agc"]),
        amino_acid("ARG", ["aga","agg"]),
        amino_acid("VAL", ["gtt","gtc","gta","gtg"]),
        amino_acid("ALA", ["gct","gcc","gca","gcg"]),
        amino_acid("ASP", ["gat","gac"]),
        amino_acid("GLU", ["gaa","gag"]),
        amino_acid("GLY", ["ggt","ggc","gga","ggg"]),
        amino_acid("***", ["taa","tag","tga"])
        ))

def readData():
    global codons 
    codons = []
    # attempt to read file
    try:
        # open file
        f = open(path, "r") 
        
        # read all lines into a single string eliminating space and removing \n
        line = f.readline().rstrip()

        # Check if file contain characters other than n,s,w,e
        if any( c not in 'acgt' for line in line for c in line):
            print("File contains undesired character.")
            exit()

        # Convert file string into list

        if len(line) % 3 != 0:
            print("\n*******************************************")
            print("Line condon sequence not multiple of 3\nExiting...")
            print("*******************************************\n")
            exit()

        n =3
        codons = [line[i:i+n] for i in range(0, len(line), n)]
            
        
        # closing file safely
        f.close()

    except IOError:
        print("\n**************************************")
        print("File \"" + path + "\" not found or can't be read.")
        print("**************************************\n")
        exit()

def dnaTranslate():

    sequence = []
    for j in codons:     
        for i in acids:
            if j in i.codons:
                sequence.append(i)
                i.count += 1
                
    
    print("\nAmino Acid Sequence: ", end="")
    for i in sequence:
        print(i.name + " ", end="")
    print("\n")
    sequence.sort(key=lambda r: r.count)
    sequence.reverse()
    print("Amino Acid Counts: ")
    for i in sequence:
        if i.name != "***":
            print(i.name + " " + str(i.count))
    

    found = 0
    for i in acids:
        if i.count >0 and i.name != "***":
            found += 1
    print("\n" + str(found) + " amino acids found")

    for i in sequence:
        if '***' in i.name:
            print("A stop codon was found.")
            break

if __name__ == "__main__":
    init()
    setAcids()
    readData()
    dnaTranslate()