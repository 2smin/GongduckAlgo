import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/16916
 *
 * 부분 문자열
 */
public class Baekjoon16916 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String p = reader.readLine();

        System.out.println(kmp(s, p));
    }

    private static int kmp(String original, String pattern) {
        int[] table = makeTable(pattern);

        int j = 0;
        for (int i = 0; i < original.length(); i++) {
            while (j > 0 && original.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }

            if (original.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    return 1;
                } else {
                    j++;
                }
            }
        }

        return 0;
    }

    private static int[] makeTable(String pattern) {
        int[] table = new int[pattern.length()];

        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                table[i] = j;
            }
        }

        return table;
    }
}