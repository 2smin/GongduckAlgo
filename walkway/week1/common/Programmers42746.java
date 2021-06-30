import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 *
 * 가장 큰 수
 * Category: Sorting
 */
class Programmers42746 {

    public String solution(int[] numbers) {
        List<String> values = new ArrayList<>();
        for (int number : numbers) {
            values.add(String.valueOf(number));
        }

        values.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder builder = new StringBuilder();
        if (Arrays.stream(numbers).allMatch(s -> s == 0)) {
            builder.append(0);
        } else {
            for (String value : values) {
                builder.append(value);
            }
        }

        return builder.toString();
    }
}