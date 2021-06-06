#include <stdio.h>
#include <stdlib.h>
#define bool int

struct node
{
    char data;
    struct node *next;
};

void push(struct node **top_ref, int new_data);

int pop(struct node **top_ref);

bool matches(char c1, char c2)
{
    if (c1 == '(' && c2 == ')')
        return 1;
    else if (c1 == '{' && c2 == '}')
        return 1;
    else if (c1 == '[' && c2 == ']')
        return 1;
    else if (c1 == '<' && c2 == '>')
        return 1;
    else
        return 0;
}

bool areBracketsBalanced(char expression[])
{
    int i = 0;

    struct node *stack = NULL;

    while (expression[i])
    {
        if (expression[i] == '{' || expression[i] == '(' || expression[i] == '[' ||
            expression[i] == '<')
            push(&stack, expression[i]);

        if (expression[i] == '}' || expression[i] == ')' || expression[i] == ']' || expression[i] == '>')
        {

            if (stack == NULL)
                return 0;

            else if (!matches(pop(&stack), expression[i]))
                return 0;
        }
        i++;
    }

    if (stack == NULL)
        return 1;
    else
        return 0;
}

void push(struct node **top_ref, int new_data)
{
    struct node *new_node = (struct node *)malloc(sizeof(struct node));

    if (new_node == NULL)
    {
        printf("Stack overflow n");
        getchar();
        exit(0);
    }

    new_node->data = new_data;

    new_node->next = (*top_ref);

    (*top_ref) = new_node;
}

int pop(struct node **top_ref)
{
    char res;
    struct node *top;

    if (*top_ref == NULL)
    {
        printf("Stack overflow n");
        getchar();
        exit(0);
    }
    else
    {
        top = *top_ref;
        res = top->data;
        *top_ref = top->next;
        free(top);
        return res;
    }
}

int main()
{
    // char expression[100] = "{()}[](";

    char expression[20];
    printf("Enter a expression: ");
    scanf("%[^\n]", &expression);

    if (areBracketsBalanced(expression))
        printf("Valid Sequence!\n");
    else
        printf("Invalid Sequence!\n");
    return 0;
}
