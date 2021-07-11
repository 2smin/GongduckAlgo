import java.util.PriorityQueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 *
 * 더 맵게
 * Category: Heap
 */
class Programmers42626 {
    public static void main(String args[]) {
        int[] scoville = new int[] {1,2,3};
        System.out.println(solution(scoville, 11));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int value : scoville) {
            heap.add(value);
        }

        while (heap.size() >= 2) {
            if (heap.stream().allMatch(s -> s >= K)) {
                return answer;
            } else {
                answer++;
            }

            heap.add(heap.poll() + heap.poll() * 2);
        }

        if (heap.size() == 1 && heap.peek() >= K) {
            return answer;
        }

        return -1;
    }
}