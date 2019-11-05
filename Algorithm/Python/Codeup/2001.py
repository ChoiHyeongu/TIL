num = []

for i in range(5) :
    n = float(input())
    num.append(n)

pasta = num[:3]
juice = num[3:]

pMin1 = min(pasta)
jMin1 = min(juice)

result = pMin1 + jMin1
result += result * 0.1

print("---------------")
print(pasta)
print(juice)
print (result)