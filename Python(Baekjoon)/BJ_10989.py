import sys
cnt = int(sys.stdin.readline()) # 갯수 입력

# Binsort (Key 대신 index로)
sort = [0 for i in range(10001)] # 0 ~ 10000까지의 Key를 (index) 갖는 Array 생성

for i in range(cnt): # 갯수만큼,
    tmp = int(sys.stdin.readline()) # 숫자 입력
    sort[tmp] += 1 # 입력받은 Key값의 Value 1 증가

for i in range(len(sort)): # Key 전체를 돌면서
    if sort[i]: # 입력받은 것이 있다면
        for j in range(sort[i]): # 그 갯수 (Value) 만큼
            print(i) # 출력
    else:
        continue