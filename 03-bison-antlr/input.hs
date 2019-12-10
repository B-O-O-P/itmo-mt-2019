fac :: Integer -> Integer
  fac n | n == 0 = 1
  fac n | n > 0 = n * fac(n - 1)

gcd :: Integer -> Integer -> Integer
  gcd a, b | b == 0 = a
  gcd a, b = gcd(a % b , b)
