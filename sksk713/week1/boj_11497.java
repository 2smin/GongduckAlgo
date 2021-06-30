import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_11497 {
    static Scanner sc = new Scanner(System.in);
    static StringTokenizer st;

    public static void main(String[] args) {
        int testCase = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(sc.nextLine());
            st = new StringTokenizer(sc.nextLine(), " ");

            int[] arr = new int[num];

            int j = 0;
            while(st.hasMoreTokens()) {
                arr[j] = Integer.parseInt(st.nextToken());
                j++;
            }

            System.out.println(solution(arr, num));
        }
    }

    static int solution(int[] arr, int num) {
        Arrays.sort(arr);
        int[] newArr = new int[num];
        int front = 0;
        int rear = num - 1;

        for (int i = 0; i < num; i++) {
            if (i % 2 == 0) {
                newArr[front] = arr[i];
                front++;
            }
            else {
                newArr[rear] = arr[i];
                rear--;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num - 1; i++) {
            int result = 0;

            if (newArr[i] - newArr[i + 1] < 0) {
                result = -(newArr[i] - newArr[i + 1]);
            }
            else
                result = newArr[i] - newArr[i + 1];

            if (result > max) {
                max = result;
            }
        }
        return max;
    }
}
