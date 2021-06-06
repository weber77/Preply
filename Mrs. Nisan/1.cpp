#include <string>
#include <iostream>
#include <vector>

using namespace std;

struct item
{ string descr;
  int price;

  item(string d, int p)
  { descr = d;
    price = p; } };

struct Link
{ item * content;
  Link * next;

  Link(item * i, Link * l)
  { content = i;
    next = l; } };

void print_list(Link * ptr)
{ while (ptr != NULL)
  { cout << ptr->content->descr
         << " @ "
         << ptr->content->price
         << "\n";
    ptr = ptr->next; } }

int main()
{ vector <item *> stock;
  stock.push_back(new item("chicken", 799));
  stock.push_back(new item("poison", 1150));
  stock.push_back(new item("beaks", 49));
  stock.push_back(new item("thing", 199));
  stock.push_back(new item("nitrogen", 2999));
  stock.push_back(new item("scum", 349));

  Link * all = NULL;

  while (true)
  { cout << "What do you want to buy? ";
    string s;
    cin >> s;

    bool found = false;
    for (int i = 0; i < stock.size(); i += 1)
      if (stock[i]->descr == s)
      { all = new Link(stock[i], all);
        found = true; }
    if (! found)
      cout << s << "Not found\n";

    cout << "I am buying:\n";
    print_list(all); } }

