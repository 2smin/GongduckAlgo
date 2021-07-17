package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class BJ1300_2 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.valueOf(bf.readLine());
        int K = Integer.valueOf(bf.readLine());

        int left = 1;
        int right = K;
        int mid;
        int answer = 0;

        while(left<=right){

            mid = (right + left) / 2;
            int cnt = sumOfCnt(mid,N);

            if(cnt >= K){
                answer = mid;
                right = mid -1;
            }else{
                left = mid + 1;
            }

        }
        System.out.println(answer);

    }

    public static int sumOfCnt(double x, int N){

        int sum = 0;

        for(int i=1; i<=N; i++){
            sum += Math.min(x/i,N);
        }
        return sum;

    }

}
