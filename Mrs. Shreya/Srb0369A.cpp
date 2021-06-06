#include<iostream>
#include<fstream>
#include<string.h>
#include <cstdlib>
#include <ctime>

using namespace std;

struct Car
{
   
   int distance[5];
   int fuel;
   double mpg;
};

int main()
{
    Car myCars[10];
    ofstream file;
    int userSize = 0;
    int randomDistance;

    file.open("car_data.txt");

    if(!file.is_open()){
        cout << "unable to open file car_data.txt\n";
        return 0;
    }

    cout << "How many cars to process? ";
    cin >> userSize;

    

    for (int j = 0; j < userSize; j++)
    {
            cout << "process car #" << (j + 1) << ":\n";
            for (int i = 0; i < 5; i++) {
                myCars[j].distance[i] = rand() % 50 + 300;
               
            }

            cout << "Total amount of fuel used: ";
            cin >> myCars[j].fuel;

            int totalCoveredDistance = 0;

            for (size_t i = 0; i < 5; i++)
            {
                totalCoveredDistance += myCars[j].distance[i];
            }
            

            myCars[j].mpg = double (totalCoveredDistance / myCars[j].fuel);

    }

    for (size_t i = 0; i < userSize; i++)
    {
        file << myCars[i].mpg << endl;
    }
        

}