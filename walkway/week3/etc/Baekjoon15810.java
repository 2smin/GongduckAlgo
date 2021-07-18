import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * https://www.acmicpc.net/problem/15810
 *
 * 풍선 공장
 */
public class Baekjoon15810 {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        String[] timeValues = reader.readLine().split(" ");
        List<Integer> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            times.add(Integer.parseInt(timeValues[i]));
        }
        times.sort(Comparator.naturalOrder());

        long answer = 0;
        long start = 0;
        long end = (long) m * times.get(times.size() - 1);

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < times.size(); i++) {
                sum += mid / times.get(i);
            }

            if (m > sum) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);

    }
}
