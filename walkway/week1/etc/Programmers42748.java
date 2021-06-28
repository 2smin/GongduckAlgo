import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 *
 * K번째 수
 * Category: Sorting
 */
class Programmers42748 {

    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];

            int[] subArray = Arrays.copyOfRange(array, start - 1, end);

            Arrays.sort(subArray);
            result[i] = subArray[k-1];
        }

        return result;
    }
}