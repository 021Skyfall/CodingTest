while 1:
    n = int(input())

    if n == -1:
        break

    arr = []

    for i in range(1, n):
        if n % i == 0:
            arr.append(i)

    if sum(arr) == n:
        d_str = ' + '.join(map(str, arr))
        print(n, '=', d_str)
    else:
        print(n,"is NOT perfect.")