import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 *
 * 큰 수 만들기
 */
class Programmers42883 {
    public static void main(String args[]) {
        System.out.println(solution("7654321", 3));
    }

    public static String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < number.length(); i++) {
            while (k > 0 && !stack.isEmpty() && number.charAt(i) > stack.peek()) {
                stack.pop();
                k--;
            }
            stack.add(number.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i  < stack.size() - k; i++) {
            result.append(stack.get(i));
        }
        return result.toString();
    }
}