/**
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 *
 * 네트워크
 */
class Programmers43162 {
    private static int length;

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    public static int solution(int n, int[][] computers) {
        length = n;
        int answer = 0;

        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                dfs(computers, node, visited);
                answer++;
            }
        }

        return answer;
    }

    private static boolean[] dfs(int[][] computers, int node, boolean[] visited) {
        visited[node] = true;

        for (int i = 0; i < length; i++) {
            if (node != i && computers[node][i] == 1 && !visited[i]) {
                visited = dfs(computers, i, visited);
            }
        }

        return visited;
    }
}