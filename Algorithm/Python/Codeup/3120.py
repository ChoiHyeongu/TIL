num, goal = map(int, input().split())
cnt = 0
while num != goal:
    isPlus = goal - num
    absolute = abs(goal-num)

    if absolute > 7 :
        if isPlus >= 0: 
            num += 10
        else:
            num -= 10
    elif absolute > 3 and absolute < 8:
        if isPlus >= 0:
            num += 5
        else:
            num -= 5
    else:
        if isPlus >= 0 :
            num += 1
        else:
            num -= 1
    cnt += 1

print (cnt)


