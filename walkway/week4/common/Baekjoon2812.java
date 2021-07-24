import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/2812
 *
 * 크게 만들기
 */
public class Baekjoon2812 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        String[] numberInput = reader.readLine().split("");
        int[] number = new int[n];
        for(int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(numberInput[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while (k > 0 && !stack.isEmpty() && number[i] > stack.peek()) {
                stack.pop();
                k--;
            }
            stack.add(number[i]);
        }

        for (int i = 0; i  < stack.size() - k; i++) {
            System.out.print(stack.get(i));
        }
    }
}