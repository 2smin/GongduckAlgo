import sys

input = sys.stdin.readline

n, m = map(int, input().split())
a = list(map(int, input().split()))

left, right, height = 0, max(a), 0
while left <= right:
    mid = (left + right) // 2
    tree = 0
    for i in range(n):
        if mid < a[i]:
            tree += a[i] - mid
    if tree >= m:
        height = mid
        left = mid + 1
    elif tree < m:
        right = mid - 1

print(height)
