#include <string>
#include <iostream>

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

  Link(item * i = NULL, Link * l = NULL)
  { content = i;
    next = l; } };

void print_list(Link * ptr)
{ while (ptr != NULL)
  { cout << ptr->content->descr
         << " @ "
         << ptr->content->price
         << "\n";
    ptr = ptr->next; } }

item * find_item(Link * ptr, string s)
{ while (ptr != NULL)
  { if (ptr->content->descr == s)
      return ptr->content;
    ptr = ptr->next; }
  return NULL; }

int total_price(Link * ptr)
{ int total = 0;
  while (ptr != NULL)
  { total += ptr->content->price;
    ptr = ptr->next; }
  return total; }

int main()
{ Link * stock = NULL;
  stock = new Link(new item("chicken", 799), stock);
  stock = new Link(new item("poison", 1150), stock);
  stock = new Link(new item("beaks", 49), stock);
  stock = new Link(new item("thing", 199), stock);
  stock = new Link(new item("nitrogen", 2999), stock);
  stock = new Link(new item("scum", 349), stock);

  Link * all = NULL;

  while (true)
  { cout << "What do you want to buy? ";
    string s;
    cin >> s;
    if (s == "exit")
      break;

    item * i = find_item(stock, s);
    if (i == NULL)
      cout << "Not found\n";
    else
      all = new Link(i, all);

    cout << "I am buying:\n";
    print_list(all); }

  cout << "Total price = " << total_price(all) << "\n"; }
