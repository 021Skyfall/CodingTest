n, m = map(int, input().split())

arr_1 = []
arr_2 = []

for _ in range(n):
    arr_1.append(input())
for _ in range(m):
    arr_2.append(input())

result = set(arr_1).intersection(arr_2)

print(len(result))
print('\n'.join(map(str, sorted(result))))