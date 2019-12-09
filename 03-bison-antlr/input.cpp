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


int main() {
 std::cout << fac(0);
}