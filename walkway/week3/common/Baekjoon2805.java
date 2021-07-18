import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/2805
 *
 * 나무 자르기
 */
public class Baekjoon2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] trees = new int[n];

        String[] treesInput = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(treesInput[i]);
        }

        Arrays.sort(trees);

        long start = 0;
        long end = trees[n-1];

        while (start <= end) {
            long mid = (start + end) / 2;
            long heightSum = 0;
            for (int tree : trees) {
                if (tree >= mid) {
                    heightSum += tree - mid;
                }
            }
            if (heightSum >= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}