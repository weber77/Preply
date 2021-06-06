#include<iostream>
#include<fstream>
#include<string.h>
using namespace std;
/*Define a structure called FileData*/
struct FileData
{
   /*A string named filename to store the name of a file,
   an integer array of size 5 named counters*/
   string fname;
   int counters[5];
};
int main()
{
   /*Declare an instance/variable of the filedata structure named myFile.*/
   struct FileData myFile;
   ifstream fi;
   int i=0,j;
   char x;
   /* initialize array counters with zeros */
   for(i=0;i<5;i++)
   {
       myFile.counters[i]=0;
   }
   /* console input of file name*/
   cout<<"Enter the file name : ";
   getline(cin,myFile.fname);
   /* open the file */
   fi.open(("e:\\" + myFile.fname).c_str());
   /* read the file charater by character */
   while (!fi.eof() )
   {
fi.get(x);
/*First element: Uppercase characters*/
           if(x>='A' && x<='Z') myFile.counters[0]++;
           /*second element: lowercase characters*/
           else if(x>='a' && x<='z') myFile.counters[1]++;
           /* third element: Digits*/
           else if(x>='0' && x<='9') myFile.counters[2]++;
           /*Fourth element: whitespaces*/
           else if(isspace(x)) myFile.counters[3]++;
           /*last element: Any other characters*/
           else myFile.counters[4]++;
   }
   /* as the end of file(eof) returns character -1
   -1 is under any other character,
   so, counter[4] will be incresed by one.That why
   myFile.counters[4] is reduced by 1
   to show exact count of other characters except eof*/
   myFile.counters[4] --;
   cout<<"Filename : "<<myFile.fname<<endl;
   /* print the array elements */
   cout<<"The counters are:"<<endl;
   for(i=0;i<5;i++)
   {
       cout<<myFile.counters[i]<<endl;
   }
return 0;  
  
}