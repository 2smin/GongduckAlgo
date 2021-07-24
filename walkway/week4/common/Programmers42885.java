import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 *
 * 구명보트
 */
class Programmers42885 {
    public static void main(String args[]) {
        System.out.println(solution(new int[] {70, 50, 80, 50}, 100));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int min = 0;
        for (int max = people.length - 1; max >= min; max--) {
            if (people[max] + people[min] <= limit) {
                min++;
            }
            answer++;
        }
        return answer;
    }
}