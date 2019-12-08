fac :: Integer -> Integer
  fac n | n == 0 = 1
  fac n | n > 0 = n * fac(n - 1)

pow :: Integer -> Integer -> Integer
                        pow a, (n | n == 0) = 1
                        pow a, (n | n % 2 == 1) = pow(a, n - 1) * a
                        pow a, n = pow(pow(a, n / 2), 2)

