cnt = int(input()) # Node 갯수 입력
tmp = str(input()).split(' ') # Node의 Parent 값 입력
tree = [int(node) for node in tmp] # tree 생성
remove = int(input()) # 제거된 Node 입력

tree[remove] = -9 # if removed, -9

def check_removed(idx): # 재귀적으로 최종 Parent까지 찾아감
    if idx == -1 or idx == -9: # Root Node or Removed Node 일 경우,
        return idx # index return
    else: # 그 외, 재귀적으로 Parent 찾아 올라감
        idx = tree[idx] 
        return check_removed(idx)

for idx in range(cnt): # 0부터 전체 Node를 탐색하면서 자식 Node들 지워줌
    if check_removed(idx) == -9:
        tree[idx] = -9

leaf_cnt = 0 # Leaf Node 갯수

for idx in range(cnt): # 0부터 전체 Node를 탐색하면서
    if tree[idx] != -9 and idx not in tree: # 지워진 Node가 아니면서 자신을 Parent로 하는 Node가 없으면
        leaf_cnt += 1 # Leaf Node 갯수 1 증가

print(leaf_cnt)