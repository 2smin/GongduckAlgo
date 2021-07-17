def solution(brown, yellow):
    for row in range(1, int(yellow**0.5) + 1):
        if yellow%row == 0:
            col = yellow//row
            if 2 * row + 2 * col + 4 == brown:
                return [col + 2, row + 2]