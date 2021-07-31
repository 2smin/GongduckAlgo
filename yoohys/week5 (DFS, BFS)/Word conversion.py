def solution(begin, target, words):
    answer = 0
    queue = [begin]
    while True:
        tmp_q = []
        for word_1 in queue:
            if word_1 == target:
                return answer
            for word_2_idx in range(len(words)-1, -1, -1):
                word_2 = words[word_2_idx]
                difference = sum([x != y for x, y in zip(word_1, word_2)])
                if difference == 1:
                    tmp_q.append(words.pop(word_2_idx))
        if not tmp_q:
            return 0
        queue = tmp_q
        answer += 1