import sys
from string import ascii_lowercase


# Function to verify program is ready to run
def init():
    global path
    # Ensure user enters all 3 arguments
    if len(sys.argv) != 2 :
        print("Program requires exaclty 2 arguments")
        exit()

    path= sys.argv[1]


def readData():
    global code
    # attempt to read file
    try:
        # open file
        f = open(path, "r") 
        
        # read all lines into a single string eliminating space and removing \n
        
        code = ""
        for line in f:
            code += line.rstrip()
            

        # Check if file contain characters other than n,gene_code,w,e
        if any( c not in 'acgt' for line in code for c in line):
            print("File contains undesired character.")
            exit()

        # Convert file string into list

        
        if len(code) % 3 != 0:
            print("\n*******************************************")
            print("Condon sequence not multiple of 3\nExiting...")
            print("*******************************************\n")
            exit()

        
            

        # closing file safely
        f.close()

    except IOError:
        print("\n**************************************")
        print("File \"" + path + "\" not found or can't be read.")
        print("**************************************\n")
        exit()

def start_codon(gene_code, codon):
    index = 0
    found = False

    if codon in gene_code:
        c = codon[0]
        for ch in gene_code:
            if ch == c:
                if gene_code[index:index+len(codon)] == codon:
                    return index

            index += 1

    print("No gene codon sequence found.")
    exit()

def end_codon(gene_code, codon):
    index = 0
    pos = gene_code.find(codon[0])
    end_codon = codon[0]

    for end in codon:
        if end in gene_code and gene_code.find(end) < pos and gene_code.find(end) %3 == 0:
            end_codon = end

    
    if end_codon in gene_code:
        c = end_codon[0]
        for ch in gene_code:
            if ch == c:
                if gene_code[index:index+len(end_codon)] == end_codon:
                    return index + 3

            index += 1

    print("No gene codon sequence found.")
    exit()

def gene_codon_seq():
    start= "atg"
    stop_codon = ["taa", "tag", "tga"]
    reversed_gene_code = code[::-1]
    begin_sub_code = start_codon(code, start)
    end_sub_codon = end_codon(code, stop_codon)
    sub_code = code[begin_sub_code : end_sub_codon] 

    result = ""
    for i in range(0,len(sub_code), 3):
        result += sub_code[i:i+3] + ' '
    print("Forward Direction: " + result)
    print("Number of Codons: " + str(len(sub_code) // 3))
    print("Number of bases: " + str(len(sub_code)))
    

    begin_sub_code = start_codon(reversed_gene_code, start)
    end_sub_codon = end_codon(reversed_gene_code, stop_codon)
    reversed_sub_code = reversed_gene_code[ begin_sub_code: end_sub_codon]
    result = ""
    for i in range(0,len(reversed_sub_code), 3):
        result += reversed_sub_code[i:i+3] + ' '

    

    print("Reversed Direction: " + result)
    print("Number of Codons: " + str(len(reversed_sub_code) // 3))
    print("Number of bases: " + str(len(reversed_sub_code)))

    
if __name__ == '__main__':
    init()
    readData()
    gene_codon_seq()