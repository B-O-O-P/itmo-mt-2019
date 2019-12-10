#include <iostream>

int fac(int a1) {
{
  int n = a1;
  if ( (n==0) ) {
    return 1;
  }
}
{
  int n = a1;
  if ( (n>0) ) {
    return n*fac(n-1);
  }
}

 return 0;
}

int gcd(int a2, int a1) {
{
  int a = a1;
  int b = a2;
  if ( (b==0) && (true) ) {
    return a;
  }
}
{
  int a = a1;
  int b = a2;
  if ( (true) && (true) ) {
    return gcd(a%b,b);
  }
}

 return 0;
}


int main() {
 std::cout << gcd(100,  40);
}