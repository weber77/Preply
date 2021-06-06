#include <stdio.h>

void cudeByValue(int *nPtr){
    *nPtr = 100;
}

int main(){
    int n = 10;
    printf("Original n = %d\n", n);

    // n = cudeByValue(n);

    // printf("Original n = %d\n", n);

    cudeByValue(&n);

    printf("New n = %d\n", n);


}