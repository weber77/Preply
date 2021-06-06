#include <stdio.h>


int main(int argc, char *argv[])
{
    if(argc == 2){
        printf("Two args %s\n", argv[0]);
    }
    else{
        printf("Not two args :p");
    }
}