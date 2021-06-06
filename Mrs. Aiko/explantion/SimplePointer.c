#include <stdio.h>

int main(){
    int a;
    int *aPtr;

    a = 7;
    aPtr = &a;

    printf("The address of a is %p"
            "\nThe value of aPtr is %p", &a, aPtr);

    printf("\n\nThe value of a is %d"
            "\nThe value of *aPtr is %d\n", a, *aPtr);

}