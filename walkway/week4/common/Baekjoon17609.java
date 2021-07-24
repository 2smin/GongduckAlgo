import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * https://www.acmicpc.net/problem/17609
 *
 * 회문
 */
public class Baekjoon17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        List<String> values = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            values.add(reader.readLine());
        }

        List<Integer> result = new ArrayList<>();
        for (String value : values) {
            if (isPalindrome(value)) {
                result.add(0);
            } else if (isPseudoPalindrome(value)) {
                result.add(1);
            } else {
                result.add(2);
            }
        }

        result.forEach(System.out::println);
    }

    private static boolean isPalindrome(String value) {
        int mid = value.length() / 2;
        int suffixStart = value.length() % 2 == 0 ? mid : mid + 1;

        String prefix = value.substring(0, mid);
        String suffix = value.substring(suffixStart);
        String reverseSuffix = new StringBuffer(suffix).reverse().toString();

        return prefix.equals(reverseSuffix);
    }

    private static boolean isPseudoPalindrome(String value) {
        int start = 0;
        int end = value.length() - 1;
        while (start <= end) {
            if (value.charAt(start) != value.charAt(end)) {
                return isPalindrome(value.substring(start, end)) || isPalindrome(value.substring(start + 1, end + 1));
            }

            start++;
            end--;
        }

        return true;
    }
}
