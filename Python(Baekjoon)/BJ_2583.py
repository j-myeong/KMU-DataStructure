from collections import deque

def bfs(i, j):
    dx = [-1, 1, 0, 0] # 위, 아래를 탐색하기 위한 상수 Array
    dy = [0, 0, -1, 1] # 양, 옆을 탐색하기 위한 상수 Array

    q = deque() # 추가적으로 탐색할 부분을 담는 Deque
    q.append([i, j]) # 인자값으로 넘어온 좌표값 부터 추가해줌

    matrix[i][j] = 1 # 인자값으로 넘어온 좌표는 Visited 했다고 설정

    size = 1 # 1개를 Visited 했기 때문에 넓이의 사이즈 1 세팅 (처음 값을 위해서)

    while q: # 추가적으로 탐색할 부분이 있을 때 까지
        tmp = q.popleft() # 탐색할 부분을 Deque에서 뽑아
        x, y = tmp[0], tmp[1] # x, y 좌표로 세팅해주고

        for idx in range(4):
            tmp_x = dx[idx] + x # 위 아래
            tmp_y = dy[idx] + y # 양 옆을 돌며 탐색함
            # 이 때, 탐색하려는 범위가 index를 넘어가지 않으면서 not visited 한지 체크
            if tmp_x < 0 or tmp_x > m - 1 or tmp_y < 0 or tmp_y > n - 1:
                continue
            # not visited 하다면
            if matrix[tmp_x][tmp_y] == 0:
                # 추가적으로 탐색을 기다리는 deque에 넣어주고
                q.append([tmp_x, tmp_y])
                # visited 했다고 표시해줌
                matrix[tmp_x][tmp_y] = 1
                # 사이즈는 1 추가
                size += 1
    
    return size


tmp = str(input()).split(' ')

m = int(tmp[0]) # M (가로) 입력
n = int(tmp[1]) # N (세로) 입력
cnt = int(tmp[2]) # 사각형의 갯수 입력

matrix = [[0] * (n) for i in range(m)] # M X N 배열 생성

sum = [] # 구역의 넓이를 저장할 Array

for i in range(cnt): # 사각형의 갯수 만큼
    a, b, c, d = str(input()).split(' ') # x,y 좌표 2개를 입력받아

    for j in range(int(b), int(d)): # 기존 배열에 1 (visited) 처리 해줌
        for k in range(int(a), int(c)):
            matrix[j][k] = 1
            
for i in range(m): # 배열을 돌면서
    for j in range(n):
        if matrix[i][j] == 0: # 0 (not visited) 을 만나면
            sum.append(bfs(i, j)) # BFS (너비 우선 탐색) 을 시작함

print(len(sum))
sum = sorted(sum)
print(" ".join(map(str, sum)))