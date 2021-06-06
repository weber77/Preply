
#include <cstdlib>
#include <ctime>
#include <iostream>

using namespace std;

int main() {
  srand((unsigned) time(0));
  int randomNumber;
  for (int index = 0; index < 10; index++) {
    randomNumber = rand() % 50 + 300;
    cout << randomNumber << endl;
  }
}