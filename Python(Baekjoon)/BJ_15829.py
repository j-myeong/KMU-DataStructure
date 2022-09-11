def hash_function(cnt, string):
    sum = 0
    for idx in range(cnt):
        sum += (ord(string[idx]) - 96) * (31 ** idx)

    return sum % 1234567891

cnt = int(input())
string = list(input())

print(hash_function(cnt, string))