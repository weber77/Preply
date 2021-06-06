#include <stdio.h>

int main(){
    static char string_literal_hello[] = { 'h', 'e', 'l', 'l', 'o', '\0' };
printf( string_literal_hello );
printf("\n%c\n", '\0');

FILE *fp;

   fp = fopen("test.txt", "w+");
   fprintf(fp, string_literal_hello);
   fputs(string_literal_hello, fp);
   fclose(fp);
}