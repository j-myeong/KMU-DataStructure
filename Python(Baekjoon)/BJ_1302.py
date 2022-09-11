cnt = int(input()) # N 입력

hash = {} # Hash Table 생성

for i in range(cnt): # N개의 책 입력
    tmp = str(input())
    if tmp not in hash: # 입력받은 책이 Hash Table에 없을 경우,
        hash[tmp] = 0 # Key 값으로 만들고 0으로 초기화
    hash[tmp] += 1 # 입력받은 책을 Key로 가지고 있는 Value값 1 증가

hash = dict(sorted(hash.items())) # 정렬

# 정렬하여 Value가 가장 큰 값을 찾고 그에 따른 index를 찾아 Key List에서 index에 맞는 키값을 가져옴
print(list(hash.keys())[list(hash.values()).index(max(hash.values()))])