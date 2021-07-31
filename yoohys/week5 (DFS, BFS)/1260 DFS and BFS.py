import sys

count_node, count_trunk, start_node = map(int, sys.stdin.readline().split(" "))

trunk_init = []
# dfs = [start_node]
bfs = [start_node]

for i in range(count_trunk):
    trunk_init.append(list(map(int, sys.stdin.readline().split(" "))))

def dfs(start_v, discoverd=[]):
  discoverd.append(start_v)
  print(start_v, end=' ')

  for w in range(len(trunk[start_v])):
    if trunk[start_v][w] == 1 and (w not in discoverd):
      dfs(w, discoverd)


# # DFS algorithm
# def find_dfs(graph, start, visited=None):
#     if visited is None:
#         visited = set()
#     visited.add(start)
#
#     print(start)
#
#     for next in graph[start] - visited:
#         find_dfs(graph, next, visited)
#     return visited


# def find_dfs(graph, node, dfs):
#
#     for tr in trunk:
#         if tr[0] not in dfs:
#             find_dfs(tr[1], trunk)
#         elif tr[1] not in dfs:
#             find_dfs(tr[0], trunk)
#
# for tr in trunk:
#     tr.sort()
#
#     if count_node == len(dfs):
#         break
#
#     if tr[0] == node and tr[1] not in dfs:
#         dfs.append(tr[1])
#         find_dfs(tr[1], trunk)
#     elif tr[1] == node and tr[0] not in dfs:
#         dfs.append(tr[0])
#         find_dfs(tr[0], trunk)


def find_bfs(node, trunk):
    i = 0
    while len(bfs) != count_node:
        for tr in trunk:
            if tr[0] == node and tr[1] not in bfs:
                bfs.append(tr[1])
            elif tr[1] == node and tr[0] not in bfs:
                bfs.append(tr[0])
        i += 1
        node = bfs[i]


if count_trunk == 1:
    if trunk_init[0] == start_node:
        print(start_node, trunk_init[0][1])
        print(start_node, trunk_init[0][1])
    else:
        print(start_node, trunk_init[0][0])
        print(start_node, trunk_init[0][0])
else:
    print(find_dfs(trunk_init, start_node))
    # print(dfs)
    find_bfs(start_node, trunk_init)
    print(bfs)
