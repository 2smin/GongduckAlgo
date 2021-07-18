import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * https://www.acmicpc.net/problem/9663
 *
 * N-Queen
 */
public class Baekjoon9663 {

    private static int result = 0;
    private static int n = 0;
    private static int[] cols;

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        cols = new int[n];

        queens(0);

        System.out.println(result);
    }

    private static void queens(int level) {
        if (level == n) {
            result++;

            return;
        }

        for(int i = 0; i < n; i++) {
            cols[level] = i;
            if(isPossible(level)) {
                queens(level + 1);
            }
        }
    }

    private static boolean isPossible(int level) {
        for(int i = 0; i < level; i++) {
            if(cols[i] == cols[level]) {
                return false;
            }

            if(Math.abs(level - i) == Math.abs(cols[level] - cols[i])) {
                return false;
            }
        }

        return true;
    }
}
