import random

n = random.randrange(1,101);
cnt = 0
answer = input();
answer = int(answer)
cnt += 1

while(answer != n):
	if answer > n:
		answer = input("입력하신 수보다 작습니다.\n")
		answer = int(answer)
		
	elif answer < n:
		answer = input("입력하신 수보다 큽니다.\n")
		answer = int(answer)
	cnt+=1

print (cnt+1,"번째 만에 맞추셨습니다!")
