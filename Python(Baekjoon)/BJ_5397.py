cnt = int(input())

left = [] # Stack (Array-Based)
right = [] # Stack (Array-Based)

for i in range(cnt):
    tmp = str(input())
    left.clear()
    right.clear()
    for char in tmp:
        if char == '<':
            if left != []:
                right.append(left.pop())
            continue
        if char == '-':
            if left != []:
                left.pop()
            continue
        if char == '>':
            if right != []:
                left.append(right.pop())
            continue
        else:
            left.append(char)
    
    right_len = len(right) # right의 len이 pop()으로 변경되기 전에 담아두는 변수

    for i in range(right_len):
        left.append(right.pop())
    
    print("".join(left))
