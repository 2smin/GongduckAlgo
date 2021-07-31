import sys
from collections import deque

input = sys.stdin.readline


def dfs(graph, v):  # implementation dfs function
    dfs_visited[v] = True
    print(v, end=' ')
    for i in graph[v]:
        if not dfs_visited[i]:
            dfs(graph, i)


def bfs(graph, start):  # implementation bfs function
    queue = deque([start])
    bfs_visited[start] = True
    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if not bfs_visited[i]:
                queue.append(i)
                bfs_visited[i] = True


N, M, V = map(int, input().split())
graph = [[] for _ in range(N + 1)]
dfs_visited, bfs_visited = [False] * (N + 1), [False] * (N + 1)  # flag init

for i in range(M):
    node1, node2 = map(int, input().split())
    graph[node1].append(node2)
    graph[node2].append(node1)

graph = [sorted(i) for i in graph]  # sort by ascending order

dfs(graph, V)
print()
bfs(graph, V)