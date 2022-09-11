tmp = str(input()).split(' ')
n = int(tmp[0])
w = int(tmp[1])
L = int(tmp[2])

bridge = [0 for i in range(w)] # Array-Based Queue

truck = str(input()).split(' ')
time = 0

while truck != [] or sum(bridge) != 0:
    bridge.pop(0) # Bridge Front-pop

    if truck != []: # 남은 Truck이 있을 때,
        next_value = int(truck[0]) 
        if (sum(bridge) + next_value) <= L:  # 다리 최대하중 Check
            bridge.append(next_value) # Bridge Back-push
            truck.pop(0) # Truck Front-pop
        else:
            bridge.append(0) # Bridge Back-push
    else: # 남은 Truck이 없을 때,
        bridge.append(0) # Bridge Back-push
    time += 1

print(time)