
Integer fac(Integer a1) {
{
  Integer n = a1;
  if ( (n==0) ) {
    return 1;
  }
}
{
  Integer n = a1;
  if ( (n>0) ) {
    return n*fac(n-1);
  }
}
}

Integer pow(Integer a2, Integer a1) {
{
  Integer a = a1;
  Integer n = a2;
  if ( (n==0) && (True) ) {
    return 1;
  }
}
{
  Integer a = a1;
  Integer n = a2;
  if ( (n%2==1) && (True) ) {
    return pow(a,n-1)*a;
  }
}
{
  Integer a = a1;
  Integer n = a2;
  if ( (True) && (True) ) {
    return pow(pow(a,n/2),2);
  }
}
}
