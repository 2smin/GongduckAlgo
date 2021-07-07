package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class PG42747 {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{10}));
    }

    public static int solution(int[] citations) {

        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[] :: new);

        Arrays.sort(arr, Comparator.reverseOrder());

        int hIndex = 0;

        for(int i=0; i<arr.length; i++){

            if(arr[i] >= i+1){
                hIndex = i+1;
            }else if(arr[i] == i){hIndex = arr[i];
                break;
            }else{
                if(hIndex < arr[i]){hIndex = arr[i];}
                break;
            }
        }

        return hIndex;
    }
}


