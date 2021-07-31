package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BJ2812 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        String[] input = bf.readLine().split(" ");

        int N = Integer.valueOf(input[0]);
        int K = Integer.valueOf(input[1]);

        String[] num = bf.readLine().split("");

        int[] nums = new int[num.length];
        for(int i=0; i<num.length; i++){
            nums[i] = Integer.valueOf(num[i]);
        }

        for(int i=0; i<nums.length; i++){

            while( K > 0 && !q.isEmpty() && q.getLast() < nums[i]){
                q.removeLast();
                K--;
            }

            q.addLast(nums[i]);
        }

        while(q.size() > K){
            sb.append(q.removeFirst());
        }
        System.out.println(sb);
    }
}
