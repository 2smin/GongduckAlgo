import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/1181
 *
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 *
 * - 길이가 짧은 것부터
 * - 길이가 같으면 사전 순으로
 */
public class Baekjoon1181 {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(reader.readLine());
        List<String> values = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            values.add(reader.readLine());
        }

        values.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        values.stream().distinct().forEach(result -> System.out.println(result));
    }
}
