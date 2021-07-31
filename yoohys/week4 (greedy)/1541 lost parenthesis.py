import sys

ab = sys.stdin.readline()
array = []

i = 0
while ab:
    if ab[i] == "+":
        array.append(int(ab[0:i]))
        ab = ab[i + 1:]
        i = 0
    elif ab[i] == "-":
        array.append(-int(ab[0:i]))
        ab = ab[i + 1:]
        i = 0
    else:
        i += 1
    print(array)
print(array)

# for i, a in enumerate(ab):
#     if a == "+":
#         array.append(ab[])
#
#     elif a == "-":
#
# print(b)
