import heapq


# 나의 풀이
def solution(operations):
    max, min = [], []
    count = 0
    for op in operations:
        if op[0] == 'I':
            heapq.heappush(max, -int(op[2:]))
            heapq.heappush(min, int(op[2:]))
            count += 1
        else:
            if op[2] == "-":
                heapq.heappop(min)
                count -= 1
            else:
                heapq.heappop(max)
                count -= 1

    if count <= 0:
        return [0, 0]
    else:
        return [-heapq.heappop(max), heapq.heappop(min)]


# 참고한 나의 풀이
def solution(operations):
    heap = []
    for op in operations:
        command, num = op.split()
        if op[0] == 'I':
            heapq.heappush(heap, int(num))
        elif heap:
            if op[2] == "-":
                heapq.heappop(heap)
            else:
                reverse_heap = [-h for h in heap]
                heapq.heapify(reverse_heap)
                heapq.heappop(reverse_heap)
                heap = [-h for h in reverse_heap]
                heapq.heapify(heap)
    if heap:
        return [max(heap), min(heap)]
    else:
        return [0, 0]
