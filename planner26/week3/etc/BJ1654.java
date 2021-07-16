package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ1654 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static long[] map;

    public static void main(String[] args) throws IOException {

        String[] arr = bf.readLine().split(" ");
        int K = Integer.valueOf(arr[0]);
        long N = Integer.valueOf(arr[1]);

        map = new long[K];

        long max = 0;
//        System.out.println("min: " + min);
        for(int i=0; i<K; i++){
            map[i] = Integer.valueOf(bf.readLine());
            max =Math.max(max, map[i]);
        }

//        System.out.println("최소: " + min);

        //랜선 갯수
        long cnt = 0;
        long start = 1;
        long end = max;
        long remMiddle = 0;

        while(start <= end){

            cnt = 0;
            long middle = (start+end)/2;

            //잘라서 갯수를 센다
            cnt = getCnt(middle);

            if(cnt < N){
                end = middle-1;
            }else if (cnt >= N) {
                remMiddle = middle;
                start = middle+1;
            }
        }
        System.out.println(remMiddle);
    }

    static long getCnt(long middle){
        long cnt = 0;

        for(int i=0; i<map.length; i++){
            cnt += (int)map[i] / (int)middle;
        }

        return cnt;
    }
}
