package sksk713.week4;

import java.io.*;
import java.util.*;

public class boj_16953 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        System.out.println(solution(from, to));

    }

    static int solution(int from, int to) {
        String toToString = Integer.toString(to);

        StringBuilder stb = new StringBuilder(toToString);
        int length = stb.length();

        if (toToString.charAt(toToString.length() - 1) != '1' && to % 2 == 1) {
            return -1;
        }

        while (from < to) {
            if (to % 2 == 0) {
                to /= 2;
            }
            else {
                if (stb.length() == 1) {
                    return -1;
                }
                else if (stb.charAt(length - 1) != '1') {
                    return -1;
                }

                stb.deleteCharAt(length - 1);
                to = Integer.parseInt(stb.toString());
            }
            cnt++;

            toToString = toToString.replace(toToString, Integer.toString(to));
            stb = new StringBuilder(toToString);
            length = stb.length();

            if (from == to) {
                return cnt + 1;
            }
        }

        return -1;
    }
}