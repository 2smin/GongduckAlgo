import java.io.*;
import java.util.*;

public class boj_1927 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> arr = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                arr.add(x);
            } else {
                if (arr.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(arr.poll());
                }
            }
        }
    }
}