#include <iostream>
#include <string.h>
#include <assert.h>
using namespace std;

int main()
{
    string date = "19630128";
    string year = date.substr(0,4);
    string months = date.substr(4,2);
    string day = date.substr(6,2);

    string newD = year + " " + months + " " +day +"\n";

    cout << newD;
     if (strcmp("2014/10/13", "2013/01/12") > 0){
         cout << "True\n";
     }
     else{
         cout << "False\n";
     }
}