#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define MAX_ARGS 1000

bool checkArg(char *uniq_args[], char *current)
{
    
    for (size_t i = 0; i < MAX_ARGS; i++)
    {
        if (strcmp(uniq_args[i], current) == 0)
        {
            return true;
        }
    }

    return false;
}

int main(int argc, char *argv[])
{

    int frequency[MAX_ARGS];
    char *uniq_args[argc];
    bool found = false;
    int cnt = 0;

    char *current;

    for (int i = 0; i < argc; i++)
    {
        frequency[i] = 1;
    }

    for (int i = 1; i < argc; i++)
    {
        current = argv[i];

        for (int j = 1; j < argc; j++)
        {
            if (strcmp(current, argv[j]) == 0 && j != i &&
                !checkArg(argv, current))
            {
                printf("Here\n");
                frequency[cnt] += 1;
            }
        }

        if (!checkArg(argv, current))
        {
            uniq_args[cnt] = current;
            cnt++;
        }
    }

    for (size_t i = 0; i < argc; i++)
    {
        printf("%d\n", frequency[i]);
    }

    int minimum = 0;

    for (int c = 1; c < argc; c++)
    {
        if (frequency[c] < frequency[minimum])
        {
            minimum = c;
        }
    }

    printf("%s\n", argv[minimum + 1]);

    return 0;
}