import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2108
 *
 * 통계학
 * Category: Sorting
 */
public class Baekjoon2108 {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(reader.readLine());
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            values.add(Integer.valueOf(reader.readLine()));
        }

        List<Integer> result = new ArrayList<>(count);
        Collections.sort(values);

        int sum = values.stream().mapToInt(Integer::intValue).sum();
        result.add((int) Math.round((double) sum/count));

        int medianIndex = count / 2;
        result.add(values.get(medianIndex));

        if (count == 1) {
            result.add(values.get(0));
        } else {
            Map<Integer, Integer> counting = new HashMap<>();
            for (Integer value : values) {
                counting.put(value, counting.getOrDefault(value, 0) + 1);
            }
            List<Integer> keySet = new ArrayList<>(counting.keySet());
            keySet.sort((o1, o2) -> {
                int compare = counting.get(o2).compareTo(counting.get(o1));
                if (compare == 0) {
                    return o1.compareTo(o2);
                }
                return compare;
            });

            if (counting.get(keySet.get(0)) == counting.get(keySet.get(1))) {
                result.add(keySet.get(1));
            } else {
                result.add(keySet.get(0));
            }

        }

        int min = values.get(0);
        int max = values.get(count-1);
        result.add(max - min);

        result.forEach(System.out::println);
    }
}
