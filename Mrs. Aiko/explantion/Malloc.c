#include <stdio.h>
#include <stdlib.h>

int main(){
    int n = 10;
    int *ptr; // int* ptr

    printf("size of array : %d\n", n);

    ptr = (int*)malloc(n * sizeof(int));

    if(ptr == NULL){
        printf("Memory not allocated. Sorry :(\n ");
        return 0;
    }
    else{
        printf("Successful memory allocation.\n");
        
        //adding data to the array indices
        for(int i =0; i<n; i++){
            ptr[i] = i + 1;
        }

        printf("The elements in our array are:");
        for(int i =0; i<n -1; i++){
            printf("%d, ", ptr[i]);
        }
        printf("%d\n", ptr[9]);
    }

    return 0;

}