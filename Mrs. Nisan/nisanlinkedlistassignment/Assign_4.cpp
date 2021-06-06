#include <iostream>
#include <fstream>
#include <string.h>

using namespace std;

class Person
{
public:
    int SSN;
    string bDate;
    string firstname;
    string lastname;
    string zipCode;

    string print()
    {
        return to_string(SSN) + " " + bDate + " " + firstname + " " + lastname + " " + zipCode + "\n";
    }
};


class Node
{

public:
    Person data;
    Node *next;
    Node(Person newData);
};


class LinkedList
{

private:
    void printrec(Node *p);

public:
    Node *head;
    LinkedList();
    void add(Person data);
    void print();
    void printrec();
};


LinkedList::LinkedList()
{
    head = nullptr;
}

void LinkedList::add(Person data)
{
    Node *newNode = new Node(data);
    newNode->next = head;
    head = newNode;
}

Node::Node(Person data)
{
    this->data = data;
    this->next = nullptr;
}

LinkedList readFile(string filename)
{
    LinkedList *persons = new LinkedList();
    ifstream file;
    file.open(filename);
    if (!file)
    {
        cerr << "Error in opening the file" << endl;
        exit(0);
    }

    Person *p = new Person();

    while (file >> p->SSN >> p->bDate >> p->firstname >> p->lastname >> p->zipCode)
    {
        persons->add(*p);
        p = new Person();
    }

    file.close();
    return *persons;
}

Person findPerson(LinkedList persons, string names)
{
    string firstname = names.substr(0, names.find(" "));
    string lastname = names.substr(names.find_first_of(" ") + 1);
    cout << firstname << " " << lastname << endl;
    Node *current = persons.head;

    while (current != nullptr)
    {
        if (current->data.firstname == firstname &&
            current->data.lastname == lastname)
        {
            return current->data;
        }
        current = current->next;
    }

    cout << names + " not found.\n";
    return *new Person();
}

LinkedList findAll(LinkedList persons, string lastname)
{

    LinkedList *newPersons = new LinkedList();
    Node *current = persons.head;

    while (current != nullptr)
    {
        if (current->data.lastname == lastname)
        {
            newPersons->add(current->data);
        }
        current = current->next;
    }

    return *newPersons;
}

LinkedList findByZip(LinkedList persons, string zip)
{

    LinkedList *newPersons = new LinkedList();
    Node *current = persons.head;
    Person *person = new Person();

    while (current != nullptr)
    {
        if (current->data.zipCode == zip)
        {
            newPersons->add(current->data);
        }

        current = current->next;
    }

    return *newPersons;
}

Person findOldest(LinkedList persons)
{
    string date;
    string year;
    string months;
    string day;
    string formatedDate1;
    string formatedDate2;

    string nextDate;
    Node *current = persons.head;
    Person oldest = current->data;

    while (true)
    {
        date = oldest.bDate;

        year = date.substr(0, 4);
        months = date.substr(4, 2);
        day = date.substr(6, 2);
        formatedDate1 = year + "/" + months + "/" + day;
        

        nextDate = current->next->data.bDate;
        year = nextDate.substr(0, 4);
        months = nextDate.substr(4, 2);
        day = nextDate.substr(6, 2);
        formatedDate2 = year + "/" + months + "/" + day;
        


        if (strcmp(formatedDate1.c_str(), formatedDate2.c_str()) > 0)
        {
            if(current->next == nullptr)
                break;
            oldest = current->next->data;
            current = current->next;
            
        }
        else
        {
            current = current->next;
            if(current->next == nullptr)
                break;
        }
        
    }

    return oldest;
}

int main()
{

    string filename = "";
    string cmd = "";
    string firstArg = "";
    string rest = "";

    cout << "Enter name of first file read from: ";
    cin >> filename;
    LinkedList persons = readFile(filename);

    cout << "=====================================================\n";
    cout << "Below are examples of commandes you can enter." << endl;
    cout << "=====================================================\n\n";
    cout << "FIND firstname lastname - find individual.\n";
    cout << "ALL lastname - display persons with same <<lastname>>.\n";
    cout << "ZIP zipcode - display persons with same <<zipcode>>.\n";
    cout << "OLDEST - print data of oldest person in DB.\n";
    cout << "EXIT - End program.\n";
    cout << "=====================================================\n\n";

    while (true)
    {
        cout << "Enter your command: ";
        getline(cin, cmd);

        firstArg = cmd.substr(0, cmd.find(" "));
        rest = cmd.substr(cmd.find_first_of(" ") + 1);

        if (firstArg == "FIND")
        {

            Person person = findPerson(persons, rest);
            cout << person.print();
            cout << "command completed!\n\n";
        }
        else if (firstArg == "ALL")
        {
            LinkedList found = findAll(persons, rest);
            Node *current = found.head;

            while (current != nullptr)
            {
                cout << current->data.print();

                current = current->next;
            }
            cout << "command completed!\n\n";
        }
        else if (firstArg == "ZIP")
        {
            LinkedList found = findByZip(persons, rest);
            Node *current = found.head;

            while (current != nullptr)
            {
                cout << current->data.print();

                current = current->next;
            }
            cout << "command completed!\n\n";
        }
        else if (firstArg == "OLDEST")
        {
            Person person = findOldest(persons);
            cout << person.print();
            cout << "command completed!\n\n";
        }
        else if (firstArg == "EXIT")
        {
            cout << "Thanks for testing.\nBye\n";
            exit(0);
        }
        else
        {
            cout << "Invalid command. Try again!\n";
        }
    }

    return 0;
}