package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ1927 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        while(total-- >0){

            int num = Integer.valueOf(bf.readLine());

            if(num==0){
                if(queue.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(queue.remove()).append("\n");
                }
            }else{
                queue.offer(num);
            }
        }

        System.out.println(sb);
    }
}
