import sys

num = int(sys.stdin.readline())
answer = 0

for i in range(1, num + 1):
    num_list = list(map(int, str(i)))
    answer = i + sum(num_list)

    if answer == num:
        print(i)
        break

    if i == num:
        print(0)