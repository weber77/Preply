#include <iostream>
#include <vector>
#include <fstream>

using namespace std;
class People
{
public:
    string name;
    string surname;
    int years;
    People() {}

private:
    People(string a, string b, int c) : name(a), surname(b), years(c) {}
};

int main()
{
    ifstream fin;
    fin.open("input.txt");
    if (!fin)
    {
        cerr << "Error in opening the file" << endl;
        return 1; // if this is main
    }

    vector<People> people;
    People temp;
    while (fin >> temp.name >> temp.surname >> noskipws >> temp.years)
    {
        ;
        people.push_back(temp);
    }

    // now print the information you read in
    for (const auto &person : people)
    {
        cout << person.name << ' ' << person.surname << ' ' << person.years << endl;
    }
}
