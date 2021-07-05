import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/11279
 *
 * 최대 힙
 * Category: Heap
 */
public class Baekjoon11279 {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(reader.readLine());
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            values.add(Integer.valueOf(reader.readLine()));
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer value : values) {
            if (value == 0) {
                if (heap.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(heap.poll());
                }
            } else {
                heap.add(value);
            }
        }
    }
}
