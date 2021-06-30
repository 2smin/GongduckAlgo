package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class BJ1181_2 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());
        TreeSet<String> set = new TreeSet<>(compareSet);

        for(int i=0; i<total; i++){
            String input = bf.readLine();
            set.add(input);
        }

        for(String str : set){
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }

    static Comparator<String> compareSet = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() > o2.length()){
                return 1;
            }else if (o1.length() < o2.length()){
                return -1;
            }else{
                return o1.compareTo(o2);
            }
        }
    };
}
