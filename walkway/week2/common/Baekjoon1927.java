import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/1927
 *
 * 최소 힙
 * Category: Heap
 */
public class Baekjoon1927 {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(reader.readLine());
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            values.add(Integer.valueOf(reader.readLine()));
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
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
