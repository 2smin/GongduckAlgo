import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/1300
 *
 * K번째 수
 */
public class Baekjoon1300 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        int start = 1;
        int end = k;

        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int order = 0;
            for (int i = 1; i < n + 1; i++) {
                order += Math.min(mid / i, n);
            }
            if (order < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
                result = mid;
            }
        }

        System.out.println(result);
    }
}