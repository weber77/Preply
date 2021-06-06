#include <stdio.h>

void average(){
    int lower, upper;
    int countEven = 0, countOdd = 0;
    double sumEven, sumOdd;

    printf("Please enter lower bound:");
    scanf("%d", &lower);

    printf("Please enter upper bound:");
    scanf("%d", &upper);

    if(lower < upper){
        for (int i = lower; i <= upper; i++)
        {
            if(i % 2 == 0){
                countEven++;
                sumEven += i;
            }
            else{
                countOdd++;
                sumOdd += i;
            }
        }
        
    }
    else{
        for (int i = lower; i >= upper; i--)
        {
            if(i % 2 == 0){
                countEven++;
                sumEven += i;
            }
            else{
                countOdd++;
                sumOdd += i;
            }
        }
        
    }

    printf("Average of even numbers between %d-%d is %0.2f\n", lower, upper, (sumEven/countEven));
    printf("Average of odds numbers between %d-%d is %0.2f\n", lower, upper, (sumOdd/countOdd));
    

}

int main(){
    char yes = 'Y';

    while (yes == 'Y' || yes == 'y')
    {
        average();
        printf("Do you want to continue?(Y/y for yes, N/n for no):");
        scanf(" %c", &yes);
        
        // yes = tolower(yes);
        while( (yes != 'Y') && (yes != 'y') && (yes != 'N') && (yes != 'n')){
            printf("\nYou have entered wrong character! Please enter Y/y for yes, N/n for no: ");
            scanf(" %c", &yes);
        }
        printf("---------------------------------------------\n");


        if(yes == 'N' || yes == 'n'){
            break;
        }
    }
    

}