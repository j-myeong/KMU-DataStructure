p_cnt = int(input()) # 사람 수 (Test Case) 입력

def find_parent(key): # 초기 친구 (Parent)를 재귀적으로 찾으면서 Union 해주는 방식
    if key == network[key][0]:
        return key
    else:
        network[key][0] = find_parent(network[key][0])
        return network[key][0]

for i in range(p_cnt):
    network = {} # Network (tree) 생성
    cnt = int(input()) # 관계 수 입력
    for j in range(cnt): # 관계 수 만큼
        person1, person2 = str(input()).split(' ') # 친구1, 친구2를 입력 받아서
        if person1 not in network: # 친구1 (Node) 이 Network (tree)에 없다면
            network[person1] = [person1, 1] # 생성하고 연결된 친구의 수 (자식과 자기 자신의 수) 를 1로 초기화
        if person2 not in network: # 친구2 또한 없다면
            network[person2] = [person2, 1] # 생성하고 1로 초기화
        
        p1_parent = find_parent(person1) # 1의 초기 친구 (Parent) 를 찾고
        p2_parent = find_parent(person2) # 2의 초기 친구 (Parent) 를 찾아

        if p1_parent != p2_parent: # 둘의 초기 친구가 다르다면
            network[p2_parent][0] = p1_parent # 2의 초기 친구를 1의 초기친구로 바꿔주고 (Union)
            network[p1_parent][1] += network[p2_parent][1] # 1의 연결된 친구 수를 2가 알고 있는 만큼 추가시켜 준다
        
        print(network[p1_parent][1])
        