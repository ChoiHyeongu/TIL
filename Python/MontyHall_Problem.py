	import random

door = ['sheep', 'sheep', 'car']
tmp = [0, 0]

random.shuffle(door)

print("D0   D1   D2")

print ("숫자를 고르세요")
before_choice = input()

cnt = 0

for i in range(0,3) :
    if door[i] == 'sheep':
        tmp[cnt] = i
        cnt += 1

open_index = random.choice(tmp)

print ("양이 위치한 문을 하나 공개하겠습니다.")
print (open_index)
print (door[open_index])

print ("문을 바꾸실거면 다른 문을 입력해주시고, 아니면 처음에 입력하신 값을 입력해주세요")
after_choice = input()
print (door[int(after_choice)])

print ("자동차가 있는 문의 번호")
print (door.index('car'))

print ("모든 문")
print (door)
