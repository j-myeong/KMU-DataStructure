import sys
from queue import PriorityQueue
input = sys.stdin.readline

MAX = 1000000001 # 거리 Max 값 (상수) 지정

n = int(input()) # N개 입력 (도시 - Node)
m = int(input()) # M개 입력 (버스 - Cost)

bus_cost = [[] for i in range(n + 1)] # 도시에 대한 Cost를 담을 Array
min_cost = [MAX] * (n + 1) # 최소 비용을 담을 Array

for i in range(m): # M개 (버스 갯수) 만큼
    tmp = str(input()).split(' ') # 입력을 받아
    bus_cost[int(tmp[0])].append([int(tmp[2]), int(tmp[1])]) # 도시에 대한 Cost 입력


tmp = str(input()).split(' ') # 입력

start = int(tmp[0]) # 시작지점
end = int(tmp[1]) # 도착지점

queue = PriorityQueue() # 거리값이 입력될 때 정렬 될 수 있도록 Priorty Queue로 지정
queue.put([0, start]) # Cost 값과 (Start에서 Start는 0), 시작지점을 Queue에 넣어줌

min_cost[start] = 0 # Start에서 자기 자신까지는 0이니까 최소 비용 Array 세팅

while not queue.empty(): # queue에 비교대상이 없을 때 까지
    c, city = queue.get() # 도시에 오기까지에 걸린 cost 값과 도시(Node)의 위치를 가져와서 (최소값으로)

    if min_cost[city] < c: # 지금까지 알고있던 최소비용과 비교를 하고
        continue
    else:
    # 알고있던 최소비용보다 작다면
        for i in bus_cost[city]:
            # 그 도시에서 더 최소비용으로 갈 수 있는지 비교하여 최소비용 업데이트
            cost = c + i[0]
            if cost < min_cost[i[1]]:
                min_cost[i[1]] = cost
                queue.put([cost, i[1]]) # 그 후, 큐에 추가하여 반복


print(min_cost[end])