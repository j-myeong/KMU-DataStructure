line = [] # Python List (Array List)
cnt = int(input())

stu = str(input()).split(' ')

for idx in range(len(stu)):
    if not stu[idx]:
        line.append(str(idx + 1))
    else:
        line.insert(len(line) - int(stu[idx]), str(idx + 1))

print(" ".join(line))