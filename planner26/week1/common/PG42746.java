package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class PG42746 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String answer = solution.solution(new int[]{5, 546});

        System.out.println(answer);
    }
}

class Solution{

    public String solution(int[] numbers) {

        String[] arr = new String[numbers.length];

        int i = 0;
        for(int num : numbers){
            arr[i] = num+"";
            i++;
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        String answer = "";

        for(int j=0; j<arr.length; j++){
            answer += arr[j];
        }

        if(answer.charAt(0) == '0'){
            answer = "0";
        }
        return answer;

//          얘는 왜 runtimeError 날까요??
//        return Integer.valueOf(answer) == 0 ? "0" : answer;
    }

}


