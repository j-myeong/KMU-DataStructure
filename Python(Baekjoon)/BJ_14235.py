from queue import PriorityQueue

cnt = int(input())

gift = PriorityQueue() # Priority Queue

for i in range(cnt):
    tmp = str(input()).split(' ')
    if tmp[0] == '0':
        if gift.empty():
            print(-1)
        else:
            print(gift.get() * -1) # -1 곱했던 내용을 원래대로 돌려주기
    else:
        for j in range(int(tmp[0])):
            gift.put(int(tmp[j + 1]) * -1) # 내림차순 정렬을 위한 -1 곱하기