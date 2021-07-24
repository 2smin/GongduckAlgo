package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1946 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        while (total-- > 0) {
            int num = Integer.valueOf(bf.readLine());
            int[] arr = new int[num+1];

            for(int i=0; i<num; i++){
                st = new StringTokenizer(bf.readLine());
                int rank = Integer.valueOf(st.nextToken());
                arr[rank] = Integer.valueOf(st.nextToken());
            }

            int count = 1;
            int pivot = arr[1];

            for(int i=1; i<arr.length; i++){

                if(arr[i] < pivot){
                    count++;
                    pivot = arr[i];
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
