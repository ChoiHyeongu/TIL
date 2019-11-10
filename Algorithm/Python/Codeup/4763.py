n = int(input())

monkey = []
A = []
B = []
cnt = 0

for i in range(n):
    monkey.append(input().split())

for i in monkey:
    print (i)
    if(monkey.index(i)):
        print (monkey.index(i))