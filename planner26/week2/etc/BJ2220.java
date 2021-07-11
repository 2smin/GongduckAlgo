package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ2220 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        int num = Integer.valueOf(bf.readLine());

        for(int i=0; i<num; i++){
            list.add(i+1);
        }

//        System.out.println(list);

        for(int i=2; i<num+1; i++){
//            System.out.println("i: " + i);
            int indexI = list.indexOf(i);
            int indexOf1 = indexI-1;

            //1과 제일 큰 수 자리 바꾸기
            int tmp = list.get(indexI);
            list.set(indexI,1);
            list.set(indexOf1,tmp);
//            System.out.println(list);
//            System.out.println("over first swap");

            int node = list.indexOf(i);

            while(node > 0){
                int rootIndex = (node-1)/2;

                int swap = list.get(node);
                list.set(node,list.get(rootIndex));
                list.set(rootIndex,swap);
                node = rootIndex;
            }

//            System.out.println(list);

        }

        for(int no : list){
            if(no!=0){
                sb.append(no).append(" ");
            }
        }

        System.out.println(sb);

    }

}
