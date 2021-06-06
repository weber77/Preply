#include<iostream>
#include<fstream>

using namespace std;

double average(double *arr, ifstream& file, int arrSize)
{
    arr = new double(arrSize);
    double input = 0.0;
    double sum = 0.0;
    for (int i = 0; i < arrSize; i++)
    {
        file >> input;

        arr[i] = input;
        sum += input;
    }

    return sum/arrSize;
    
}

int main()
{
    ifstream file("read_data.txt");

    if(!file.is_open())
    {
        cout << "Can't open file";
        return 0;
    }

    int size;
    cout << "Array size: ";
    cin >> size;

    double *array = new double(size);

    cout << "the average is: " << average(array, file, size);




}
