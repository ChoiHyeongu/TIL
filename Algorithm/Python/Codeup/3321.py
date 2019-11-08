import math

n = int(input())
dPrice, tPrice = map(int, input().split())
dCal = int(input())
tCal = []
calMax = dCal
pMax = 0
cases=[]
result = 0
k=0

for i in range(n):
    tCal.append(int(input()))

tCal.sort()
cases.append(math.floor(dCal/dPrice))

for i in range(n):
    for j in range(n-i):
        j+=i
        calMax += tCal[j]
        pMax = dPrice + (tPrice * (j-i+1))
        cases.append(math.floor(calMax/pMax))
    
    calMax = dCal
    pMax = 0

print (max(cases))