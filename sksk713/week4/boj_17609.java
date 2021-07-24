package sksk713.week4;

import java.io.*;

public class boj_17609 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            solution(input);
        }
    }

    static void solution (String x) {
        StringBuilder y = new StringBuilder(x);
        if (y.toString().equals(y.reverse().toString())) {
            System.out.println(0);
            return;
        }

        int start = 0;
        int end = x.length() - 1;
        int operFlag = 0; // 케이스가 있는지 없는지 체크 없으면 불가능 1이면 함 0이면 안함
        int flag = 0; // 문자 삭제를 하고 같은지 아닌지 체크 1이면 다름 0이면 같음

        while (start <= end) {
            if (x.charAt(start) != x.charAt(end)){

                if (x.charAt(start + 1) == x.charAt(end)) {
                    operFlag = 1;
                    StringBuilder a = new StringBuilder(x);
                    a.deleteCharAt(start);
                    if (a.toString().equals(a.reverse().toString())) {
                        System.out.println(1);
                        return;
                    }
                    else {
                        flag = 1;
                    }
                }

                if (x.charAt(start) == x.charAt(end - 1)) {
                    operFlag = 1;
                    StringBuilder b = new StringBuilder(x);
                    b.deleteCharAt(end);
                    if (b.toString().equals(b.reverse().toString())) {
                        System.out.println(1);
                        return;
                    }
                    else {
                        flag = 1;
                    }
                }

                if (operFlag != 1 || flag == 1) {
                    System.out.println(2);
                    return;
                }
            }

            start++;
            end--;
        }
    }
}