import sys
import csv

# Function to verify program is ready to run
def init():
    global path
    # Ensure user enters all 3 arguments
    if len(sys.argv) != 2 :
        print("Program requires exaclty 2 arguments")
        exit()

    path = sys.argv[1]


class record:
    def __init__(self, date, county, new_positive, cumul_positive, total_test_performed, cumul_number_test_performed):
        self.date = date
        self.county = county
        self.new_positive = new_positive
        self.cumul_positive = cumul_positive
        self.total_test_performed = total_test_performed
        self.cumul_number_test_performed = cumul_number_test_performed

records = []

def read_data():
    try:
        with open(path, 'r') as f:
            reader = csv.reader(f)
            for row in reader:
                records.append(record(row[0], row[1], row[2], row[3], row[4], row[5]))

            f.close()
    except IOError:
        print("\n**************************************")
        print("File \"" + path + "\" not found or can't be read.")
        print("**************************************\n")
        exit()

def compute(search_county):
    found_list = []
    sum_f1 = 0.00 
    sum_f2 = 0.00
    for i in records:
        if(i.county == search_county):
            found_list.append(i)
    found_list.sort(key=lambda r: r.date)

    print("\n"+ search_county + " County:")
    print("%s\t%s\t%s\t%s"% ("Test Date", "Positive", "Tests Performed", "Frequency(Cumulative freq.)"))
    

    for i in found_list:
        positive = int(i.new_positive)
        test_performed = int(i.total_test_performed)
        cum_positve = int(i.cumul_positive)
        cum_test = int(i.cumul_number_test_performed)

        fr1 = 0.00
        fr2 = 0.00
        try:
            fr1 = positive/test_performed *100
            fr2 = cum_positve/cum_test *100
        except ZeroDivisionError:
            fr1 = 0.00
            fr2 = 0.00
        sum_f1 += fr1
        sum_f2 += fr2
        print("%s\t%8s\t%15s%16.2f%%   (%.2f%%)" % (i.date, i.new_positive, i.total_test_performed,fr1,fr2))

    print("\nStatistics for {0} County".format(search_county))
    print("First Positive discovered: " + firstPos(found_list).date)

    highestTest = maxtest(found_list)
    print("Highest number of test performed: " + highestTest.total_test_performed + " on " + highestTest.date )

    highestPos = maxpositive(found_list)
    print("Highest number of positive discorvered: " + highestTest.new_positive + " on " + highestTest.date )

    print("Average positivity frequency: %0.2f%%" % (sum_f1/len(found_list)))
    print("Average cumulative positivity frequency: %0.2f%%" % (sum_f2/ len(found_list)))



def maxpositive(new_list):
    max = new_list[0]
    for i in new_list:
        if int(max.new_positive) < int(i.new_positive):
            max = i
    
    return max

def maxtest(list):
    max = list[0]
    for i in list:
        if int(i.total_test_performed) > int(max.total_test_performed):
            max = i
    return max

def firstPos(list):
    for i  in list:
        if int(i.new_positive) != 0:
            return i
if __name__ == '__main__':
    init()
    read_data()
    while True:
        county = input("Enter the name of a county, or enter \"quit\" to quit: ")

        if county != "quit":
            compute(county)
        elif county == "quit":
            print("Thanks for testing🤓")
            exit()


