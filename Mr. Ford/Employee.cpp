#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

class Employee
{
public:
    int id;
    double hourlyRate;
    string name;
    double totalWage;

    string print()
    {
        return name + ", $" + to_string(totalWage) + "\n";
    }
};

class IdRate
{
public:
    int id;
    double hourlyRate;
};

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

void SortList(Node<Employee *> head)
{
    Node<Employee *> *node = nullptr, *temp = nullptr;
    Employee emp; //temp variable to store node data
    node = &head;
    //temp = node;//temp node to hold node data and next link
    while (node != NULL)
    {
        temp = node;
        while (temp->next != nullptr) //travel till the second last element
        {
            if (temp->data->totalWage > temp->next->data->totalWage) // compare the data of the nodes
            {
                emp = *temp->data;
                temp->data = temp->next->data; // swap the data
                *temp->next->data = emp;
            }
            temp = temp->next; // move to the next element
        }
        node = node->next; // move to the next node
    }
}

LinkedList<Employee *> readFirst(string filename)
{
    LinkedList<Employee *> *emps = new LinkedList<Employee *>();
    ifstream file;
    file.open(filename);
    if (!file)
    {
        cerr << "Error in opening the file" << endl;
    }

    Employee *e = new Employee();

    while (file >> e->id >> e->hourlyRate >> e->name)
    {
        emps->add(e);
        // cout << e->id << " " << e->hourlyRate  << " " <<e->name << endl;
        e = new Employee();
    }

    file.close();
    return *emps;
}

vector<IdRate> readSecond(string filename)
{
    ifstream file;
    file.open(filename);
    if (!file)
    {
        cerr << "Error in opening the file" << endl;
    }

    vector<IdRate> idRate;
    IdRate temp;
    while (file >> temp.id >> temp.hourlyRate)
    {
        idRate.push_back(temp);
    }

    return idRate;
}

int main()
{

    string filename;

    cout << "Enter name of first file to open: ";
    cin >> filename;
    LinkedList<Employee *> emps = readFirst(filename);

    cout << "Enter name of second file to open: ";
    cin >> filename;
    vector<IdRate> idRate = readSecond(filename);

    cout << "Enter name of output file: ";
    cin >> filename;

    int totalHours = 0;

    // Calculate and set total wages of employee
    for (int i = 0; i < idRate.size(); i++)
    {

        for (int j = 0; j < idRate.size(); j++)
        {

            if (idRate.at(j).id == idRate.at(i).id)
            {
                totalHours += idRate.at(j).hourlyRate;
            }
        }

        // search for employee in linked list
        Node<Employee *> *current = emps.head;

        while (current != nullptr)
        {

            if (current->data->id == idRate.at(i).id)
                current->data->totalWage = totalHours;
            current = current->next;
        }

        totalHours = 0;
    }

    //======================================
     //*********printPayroll *************//
    //======================================
    ofstream file(filename);
    if (file.is_open())
    {
        file << "*********Payroll Information********\n";
        Node<Employee *> *current = emps.head;

        while (current != nullptr)
        {
            file << current->data->name << ", $" << current->data->totalWage << endl;

            current = current->next;
        }

        file << "*********End payroll**************";
        file.close();
    }
    else
        cout << "Unable to open output file: " + filename << endl;
    cout << "Execution Completed. Open " + filename + " to see results" << endl;
    return 0;
}