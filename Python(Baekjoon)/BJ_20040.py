import sys
sys.setrecursionlimit(200000)

input = sys.stdin.readline

tmp = str(input()).split(' ')

cnt = int(tmp[0])
line = int(tmp[1])

cycle = [i for i in range(cnt)]

def parent_find(idx): # 부모 Node를 재귀적으로 찾으면서 Union 하는 함수
    if idx == cycle[idx]:
        return idx
    else:
        cycle[idx] = parent_find(cycle[idx])
        return cycle[idx]

def union(node1, node2): # Cycle이 되는 순간을 판단하는 함수
    node1_parent = parent_find(node1) # Node 1의 부모와
    node2_parent = parent_find(node2) # Node 2의 부모를 찾아
    if node1_parent > node2_parent: # 작은 것이 부모 Node가 될 수 있도록
        node1_parent, node2_parent = node2_parent, node1_parent # 순서를 바꿔주고

    if node1_parent == node2_parent: # 만약 같다면 (Cycle이 완성이 된다면)
        return True # True를
    else: # 아니라면
        cycle[node2_parent] = node1_parent # Union 하고
        return False # False를 리턴
         
rt = 0

for i in range(line):
    tmp = str(input()).split(' ')
    node1 = int(tmp[0])
    node2 = int(tmp[1])
    if union(node1, node2):
        rt = i + 1
        break

print(rt)