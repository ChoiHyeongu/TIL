import math

n = int(input())
a, b = map(int, input().split())
dow = int(input())
cal = []
sum = 0
max = 0

max = dow/a
sum = dow

for i in range(n):
    cal.append(int(input()))

cal.sort()

for i in range (n-1, 0, -1):
    sum += cal[i]
    if(max < sum / (a+b*(n-i))):
         max = sum / (a+b*(n-i))

    # print (sum / (a+b*(n-i)))

print (math.floor(max))