a, b, c, d, e = map(int, input().split(" "))
mina = 0
minb = 0
min = 0

if a <= b and a <= c:
     mina = b
elif b <= a and b <= c :
    mina = b
else :
    mina = c

if d <= e :
    minb = d
else :
    minb = e

min = mina + minb
print (min)