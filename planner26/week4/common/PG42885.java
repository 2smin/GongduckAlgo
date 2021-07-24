package programmers;
import java.util.Arrays;

public class PG42885 {

    public static void main(String[] args) {

    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int start = 0;
        int end = people.length-1;

        while(start < end){

            int sum = people[start] + people[end];
            if(sum > limit){
                end--;
            }else{
                start++;
                end--;
            }

            answer++;
        }

        if(start == end){
            answer++;
        }
        return answer;
    }
}

