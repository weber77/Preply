#include <iostream>
using namespace std;

struct Node{
    int data;
    struct Node *next;
};

void push(struct Node** head, int value){

    struct Node* newNode = new Node;

    newNode->data = value;

    newNode->next = (*head);

    (*head) = newNode;

}

void insert(struct Node* preNode, int data){
    if(preNode != NULL){
        struct Node* newNode = new Node;

        newNode->data = data;
        newNode->next = preNode->next;
        preNode->next = newNode;
        return;
  
    }

    cout<< " We are at the begining!";
}

void append(struct Node** head, int data){
    struct Node* newNode = new Node;

    struct Node *last = *head;

    newNode->data = data;

    newNode->next = NULL;

    if(*head == NULL){
        *head = newNode;
        return;
    }

    while(last->next != NULL){
        last = last->next;
    }

    last->next = newNode;

}

void display(struct Node *node){

    while(node != NULL){
        cout << node->data << "->";
        node = node->next;
    }

    if(node == NULL){
        cout<<"end\n";
    }
}

int main(){
    struct Node* head = NULL;
    append(&head, 70);
    push(&head, 30);
    push(&head, 20);
    insert(head->next, 5);

    cout<<"Here is your list: \n";
    display(head); 
}