import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43238
 *
 * 입국심사
 */
class Programmers43238 {
    public static void main(String args[]) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    public static long solution(int n, int[] times) {
        Arrays.sort(times);

        long answer = 0;
        long start = 0;
        long end = (long) n * times[times.length - 1];

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }

            if (n > sum) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}