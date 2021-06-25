package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ18870 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static Comparator<HashMap.Entry<Integer, Integer>> compareWithValue = new Comparator<HashMap.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) { return o1.getValue() >= o2.getValue() ? 1 : -1; }
    };

    static Comparator<HashMap.Entry<Integer, Integer>> compareWithKey = new Comparator<HashMap.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) { return o1.getKey() >= o2.getKey() ? 1 : -1; }
    };

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());
        String[] inputs = bf.readLine().split(" ");

        HashMap<Integer,Integer> numList = new HashMap<>();
        int[] indexArr = new int[total];

        for(int i=0; i<total; i++){ numList.put(i,Integer.valueOf(inputs[i])); }

        List<HashMap.Entry<Integer,Integer>> sortedWithValue = new ArrayList<>(numList.entrySet());

        sortedWithValue.sort(compareWithValue);

        int k = 0;
       for(int i=1; i<total; i++){
           if(sortedWithValue.get(i).getValue().equals(sortedWithValue.get(i-1).getValue())){
               indexArr[i] = indexArr[i-1];
           }else{
               indexArr[i] = ++k;
           }
       }

       for(int i=0; i<total; i++){ sortedWithValue.get(i).setValue(indexArr[i]); }

       sortedWithValue.sort(compareWithKey);

       for(int i=0; i<total; i++){
           sb.append(sortedWithValue.get(i).getValue()).append(" ");
       }

        System.out.println(sb);

    }

}
