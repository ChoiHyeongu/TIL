import math

n = int(input())
dPrice, tPrice = map(int, input().split())
dCal = int(input())
tCal = []
calMax = dCal
pMax = 0
cases=[]
result = 0

for i in range(n):
    tCal.append(int(input()))

tCal.sort()
print (tCal)

k=0

for i in range(n):
    j = i
    for j in range(n-1, j):
        calMax += tCal[j]
    
    result = math.floor(calMax/(dPrice+i*tPrice))
    cases.append(result)

print (cases)