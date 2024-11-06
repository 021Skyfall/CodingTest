import sys

while line := sys.stdin.readline().strip():
    if line == "":
        break

    a, b = map(int, line.split())

    print(a + b)