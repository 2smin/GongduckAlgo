package sksk713.week4;

import java.io.*;
import java.util.*;

public class boj_2109 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] schedule;
    static boolean[] visit;
    static PriorityQueue<Integer> qu = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        schedule = new int[n][2];
        visit = new boolean[n];
        int due = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (due < x) {
                due = x;
            }
            schedule[i][0] = x;
            schedule[i][1] = p;
        }

        Arrays.sort(schedule, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    if (o1[1] > o2[1]) {
                        return -1;
                    }
                    else return 1;
                }
                else if (o1[0] > o2[0]) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < n; i++) {
            int d = schedule[i][0];
            int p = schedule[i][1];
            qu.add(p);

            while (d < qu.size()) {
                qu.remove();
            }
        }

        int sum = 0;

        for (int a : qu) {
            sum += a;
        }
        System.out.println(sum);
    }
}
