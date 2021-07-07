import heapq
import sys

# def solution():
heap = []
answer = []
length = int(input())
while length > 0:
    ip = int(sys.stdin.readline())  # input보다 훨씬 빠름
    if ip == 0:
        if heap:
            print(-heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, -ip)
    length -= 1
