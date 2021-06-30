import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_18870 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] answer;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        answer = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            answer[i] = arr[i];
        }

        solution(arr);
    }

    static void solution(int[] arr){
        Arrays.sort(arr);
        int pivot = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(pivot != arr[i]){
                map.put(arr[i], index++);
                pivot = arr[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.length; i++){
            sb.append(map.get(answer[i]) + " ");
        }
        System.out.println(sb);
    }
}