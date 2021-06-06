#include<iostream>
#include<fstream>
using namespace std;

int main(){
        //defining an array to store 9 float values
        float values[9];
        //asking, reading 9 values into the array
        cout<<"Enter 9 floating point numbers: ";
        for(int i=0;i<9;i++){
                cin>>values[i];
        }
        
        //opening differences.dat file in write mode
        ofstream ofile("differences.dat");
        //if file not opened correctly, displaying error and exiting
        if(!ofile.good()){
                cout<<"Error: differences.dat file cannot be opened"<<endl;
                return 0;
        }
        //now looping through first 8 values on the array
        for(int i=0;i<8;i++){
                //finding difference with last value on the array and
                //writing result to ofile.
                ofile<<(values[8]-values[i])<<endl;
        }
        //closing file, saving changes.
        ofile.close();
        return 0;
}
