package programmers;

public class PG43165 {

    public static void main(String[] args) {

        int[] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers,target));
    }

    static int count = 0;

    public static int solution(int[] numbers, int target) {

        DFS(0,numbers, 0, target);

        int answer = count;
        return answer;
    }

    public static void DFS(int sum, int[] arr, int depth, int target){

        if(depth < arr.length){

            int removed = arr[depth];
            int plus = sum + removed;
            int minus = sum - removed;

            DFS(plus, arr, depth+1, target);
            DFS(minus, arr, depth+1, target);

        }else{
            if(sum == target)  count++;
            return;
        }

    }
}
