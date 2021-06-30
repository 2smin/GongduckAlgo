import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * https://www.acmicpc.net/problem/18870
 *
 * 좌표 압축
 * Category: Sorting
 */
public class Baekjoon18870 {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        String[] stringValues = reader.readLine().split(" ");
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            values.add(Integer.parseInt(stringValues[i]));
        }

        List<Integer> sorted = values.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        Map<Integer, Integer> result = new HashMap<>();
        int compression = 0;
        for (Integer value : sorted) {
            if (!result.containsKey(value)) {
                result.put(value, compression++);
            }
        }

        StringBuilder builder = new StringBuilder();
        values.forEach(key -> builder.append(result.get(key)).append(' '));

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(builder.toString());
        writer.flush();
        writer.close();
    }
}
