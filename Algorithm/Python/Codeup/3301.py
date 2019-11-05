import math

num = int(input())
value = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
count = [0, 0, 0, 0, 0, 0, 0, 0]

for i in range(8) :
    if(num >= value[i]):
         count[i] = math.floor(num / value[i])
         num %= value[i]

print(count)
print(int(sum(count)))