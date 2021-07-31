def solution(n, lost, reserve):
    n -= len(lost)
    for re in reserve:
        if re in lost:
            reserve.remove(re)
            lost.remove(re)
            n += 1
    for re2 in reserve:
        i = 0
        while i < len(lost):
            if abs(re2 - lost[i]) <= 1:
                n += 1
                print(lost[i])
                del lost[i]
                i += 1
                break
            i += 1
    return n
