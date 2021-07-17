package programmers;

public class PG43238_2 {

    public static void main(String[] args) {

        int[] times = {7,10};
        int n = 6;
        long time = solution(n,times);
        System.out.println("time: " + time);
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        long max = getMax(times,n);

        long left = 0;
        long right = max;
        long time = 0;

        while(left <= right){

            long middle = (left + right)/2;
            long sum = 0;

            for(int i=0; i<times.length; i++){
                sum += middle/times[i];
            }

            if(sum < n){
                left = middle+1;
            }else{
                time = middle;
                right = middle-1;
            }
        }
        return time;
    }

    public static long getMax(int[] times, int n){

        long max = 0;
        for(int i=0; i<times.length; i++){
            if(max < times[i]){
                max = times[i];
            }
        }

        return n*max;
    }
}
