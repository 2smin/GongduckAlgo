/**
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 *
 * 타겟 넘버
 */
class Programmers43165 {
    public static void main(String args[]) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }

    private static int dfs(int[] numbers, int target, int node, int sum) {
        if (node == numbers.length) {
            return sum == target ? 1 : 0;
        }

        return dfs(numbers, target, node + 1, sum + numbers[node])
                + dfs(numbers, target, node + 1, sum - numbers[node]);
    }
}