
#include <stdio.h>
#include <stdbool.h>

struct container
{
    struct node *list1; 
    struct node *list2;
    
};

struct node
{
    int data;
    struct node* next;
    
};

void remove_outlier(struct container *container)
{
    bool found =false;
    struct node *current  = container->list1->data;
    while(true){
        int elementL2 = container->list2->data;
        
        while (container->list1->next != NULL)
        {
            if(elementL2 == container->list1->data)
            {
                found = true;
                break;
            }
            else{
                current = container->list1->next;
            }
        }

        if(found == false){
            while (container->list2->next != NULL)
            {
                struct node *current;
                
                if(elementL2 == container->list2->next->data)
                {
                    current = container->list2->data;
                    container->list2->next->next = NULL;
                    container->list2->next = current->next;
                    break;
                }

            }
            break;

        }

        
    }
};
