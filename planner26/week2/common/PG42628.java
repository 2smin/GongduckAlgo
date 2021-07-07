package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PG42628 {

    static Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.valueOf(o1) > Integer.valueOf(o2) ? -1 : 1;
        }
    };

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static LinkedList<String> list = new LinkedList<String>();

    public static void main(String[] args) throws IOException {

        System.out.println(Arrays.toString(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));

    }

    public static int[] solution(String[] operations) {

        for(int i=0; i<operations.length; i++){

            String[] order = operations[i].split(" ");

            //I일 경우 숫자 삽입
            if(order[0].equals("I")) {
                list.add(order[1]);
            }else if (!list.isEmpty() && order[0].equals("D")){

                    if(order[1].equals("1")){
                        list.removeFirst();
                    }else if(order[1].equals("-1")){
                        list.removeLast();
                    }

            }

            Collections.sort(list,comparator);

        }
        int[] answer;

        if(list.isEmpty()){
            answer = new int[]{0,0};
        }else{
            answer = new int[]{Integer.valueOf(list.removeFirst()),Integer.valueOf(list.removeLast())};
        }
        return answer;
    }
}
