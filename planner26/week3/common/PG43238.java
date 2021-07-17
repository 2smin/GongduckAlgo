package programmers;

import java.util.Arrays;
import java.util.Collections;

public class PG43238 {

    //인원 수 배열
    static int[] arr;


    public static void main(String[] args) {
        int[] times = {5,2,6,8,5};
        int n = 10;

        Integer[] integerArr = Arrays.stream(times).boxed().toArray(Integer[]::new);
        arr = new int[integerArr.length];
        arr[0] = n;
        Arrays.sort(integerArr, Collections.reverseOrder());

        System.out.println("times order: " + Arrays.toString(integerArr));
        System.out.println("arr: " + Arrays.toString(arr));

        long max = 0;
        for(int i=1; i<integerArr.length; i++){
            System.out.println("i: " + i);
            max = divideWaiting(integerArr, i);
        }

        System.out.println(max);
    }

    public static long divideWaiting(Integer[] times, int n){

        //최대값 찾기
        long max=0;

        //n이 최대값이 되기 직전까지 돌린다.
        while(true){
            System.out.println();

            max = 0;
            //최대값의 위치를 찾고
            int index = 0;
            for(int i=0; i<times.length; i++){
                if(max < times[i] * arr[i]){
                    max = times[i] * arr[i];
                    index = i;
                }
            }

            System.out.println("max: " + max);
            System.out.println("times: " + Arrays.toString(times));
            System.out.println("arr: " + Arrays.toString(arr));

            if(index == n || times[n] * (arr[n]+1) >= max){
                break;
            }
            //최대값의 위치에서 하나씩 빼준다.
            arr[index]--;
            arr[n]++;
        }
        //다음 최대값을 찾는다
        return max;
    }

}
