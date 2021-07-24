import sys

cost = 0
stations = int(sys.stdin.readline())
meeters = list(map(int, sys.stdin.readline().split()))
cities = list(map(int, sys.stdin.readline().split()))

cities.pop()
cities.reverse()
meeters.reverse()

while cities:
    index = cities.index(min(cities))
    cost += min(cities) * sum(meeters[0:index + 1])
    cities = cities[index + 1:]
    meeters = meeters[index + 1:]

print(cost)
