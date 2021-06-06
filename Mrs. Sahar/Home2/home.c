#include <stdio.h>

void average(int m, int f){
    double average = m*0.40 + f*0.6;

    if(average >= 90 && average <= 100){
        printf("Your Letter Grade is: A\n");
    }
    else if(average >= 80 && average < 90){
        printf("Your Letter Grade is: B\n\n");
    }else if(average >= 70 && average < 80){
        printf("Your Letter Grade is: C\n\n");
    }else if(average >= 60 && average < 70){
        printf("Your Letter Grade is: D\n\n");
    }else if(average >= 0 && average < 60){
        printf("Your Letter Grade is: F\n\n");
    }

}

int main(){
    int mGrade, fGrade;
    
    while (1)
    {
        printf("Enter your Midterm grade: ");
        scanf("%d", &mGrade);

        printf("Enter your Final grade: ");
        scanf("%d", &fGrade);

        if( mGrade < 0 || fGrade <0){
            break;
        }
        
        average(mGrade, fGrade);
        
    }

    printf("You entered negative value. Bye\n");
    printf("-------------------------------\n");
    

    return 0;

}



