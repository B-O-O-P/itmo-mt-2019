fac :: Integer -> Integer
  fac n | n == 0 = 1
  fac n | n > 0 = n * fac(n - 1)

