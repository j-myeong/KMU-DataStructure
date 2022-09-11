n = int(input())
heap = []

def siftUp(idx):
    if idx <= 0:
        return
    while True:
        p_idx = int((idx - 1) / 2)
        if heap[p_idx] < heap[idx]:
            heap[p_idx], heap[idx] = heap[idx], heap[p_idx]
            idx = p_idx
            continue
        else:
            break

def siftDown(idx):
    n = len(heap) - 1
    while not isLeaf(idx):
        if not (idx >= 0 and idx < n):
            break
        child = 2 * idx + 1
        if child < n and heap[child] < heap[child + 1]:
            child += 1
        if (heap[idx] >= heap[child]):
            break;
        heap[idx], heap[child] = heap[child], heap[idx]
        idx = child

def isLeaf(idx):
    len_heap = len(heap)
    return int(len_heap / 2) <= idx < len_heap

def removemax():
    n = len(heap) - 1
    heap[0], heap[n] = heap[n], heap[0]
    rt = heap.pop()
    siftDown(0)
    return rt

for i in range(n):
    tmp = int(input())
    heap.append(tmp * -1)
    siftUp(len(heap) - 1)
    
for i in range(n):
    print(removemax() * -1)