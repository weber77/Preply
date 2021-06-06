#include <iostream>
using namespace std;

template <class T>
class LinkedList;

template <class T>
class Node
{
    

public:
T data;
    Node<T> *next;
    Node(T newData);

    friend LinkedList<T>;
};

template <class T>
class LinkedList
{
    

private:
    void printrec(Node<T> *p);

public:
Node<T> *head;
    LinkedList();
    void add(T data);
    void print();
    void printrec();
};

template <class T>
LinkedList<T>::LinkedList()
{
    head = nullptr;
}

template <class T>
void LinkedList<T>::add(T data)
{
    Node<T> *newNode = new Node<T>(data);
    newNode->next = head;
    head = newNode;
}

template <class T>
Node<T>::Node(T data)
{
    this->data = data;
    this->next = nullptr;
}

template <class T>
void LinkedList<T>::print()
{
    Node<T> *p = head;

    while (p != nullptr)
    {
        cout << p->data << endl;
        p = p->next;
    }
}

template <class T>
void LinkedList<T>::printrec(Node<T> *p)
{
    if (p == nullptr)
        return;

    cout << p->data << endl;
    printrec(p->next);
}

template <class T>
void LinkedList<T>::printrec()
{
    this->printrec(head);
}

class Employee
{
public:
    int id;
    string name;
    double rate;
};

int main()
{
    LinkedList<string> *names = new LinkedList<string>();
    LinkedList<int> *grades = new LinkedList<int>();

    LinkedList<Employee *> *emps = new LinkedList<Employee *>();
    
    Employee *e = new Employee();
    e->id = 23;
    e->name = "Carmine";
    e->rate = 10.0;
    Node<Employee *> em = e;

    emps->add(e);
    e = new Employee();
    e->id = 23;
    e->name = "Carminev";
    e->rate = 10.0;
    
    emps->add(e);

    names->add("Carmine");
    grades->add(90);

    names->add("James");
    grades->add(88);

    names->print();
    grades->print();

    Node<Employee *> *current = emps->head;

        while (current != nullptr)
        {
            cout << current->data->name;
            cout << current->data->name << ", $" << endl;

            current = current->next;
        }
    cout << em.data->id;
}