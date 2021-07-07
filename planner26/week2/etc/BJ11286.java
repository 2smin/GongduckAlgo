package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ11286 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {

            int absO1 = Math.abs(o1);
            int absO2 = Math.abs(o2);

            if(absO1>absO2){
                return 1;
            }else if (absO1<absO2){
                return -1;
            }else{
                return o1.compareTo(o2);
            }
        }
    };

    static PriorityQueue<Integer> priorQ = new PriorityQueue<>(comparator);

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        while(total-- > 0){

            int num = Integer.valueOf(bf.readLine());

            if(num!=0){
                priorQ.offer(num);
            }else{
                if(priorQ.isEmpty()){
                    sb.append(0);
                }else{
                    sb.append(priorQ.poll());
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
