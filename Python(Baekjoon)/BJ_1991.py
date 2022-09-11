tree = {} # Dictionary (Tree)
cnt = int(input()) # Node 갯수 입력

for i in range(cnt): # Node 갯수 만큼
    tmp = str(input()).split(' ') # Node (Key)를 입력받아
    if tmp[0] not in tree.keys(): # Node가 없다면
        tree[tmp[0]] = ['.', '.'] # 새로 만들어서 Leaf Node로 초기화하고
    tree[tmp[0]][0] = tmp[1] # 입력받은 왼쪽 자식
    tree[tmp[0]][1] = tmp[2] # 오른쪽 자식으로 설정

def preorder(root):
    if root == '.':
        return;
    print(root, end='')
    preorder(tree[root][0])
    preorder(tree[root][1])

def inorder(root):
    if root == '.':
        return;
    inorder(tree[root][0])
    print(root, end='')
    inorder(tree[root][1])

def postorder(root):
    if root == '.':
        return;
    postorder(tree[root][0])
    postorder(tree[root][1])
    print(root, end='')

preorder('A')
print()
inorder('A')
print()
postorder('A')