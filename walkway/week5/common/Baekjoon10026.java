import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * https://www.acmicpc.net/problem/10026
 *
 * 적록색약
 */
public class Baekjoon10026 {
    private static int n;
    private static char[][] picture;
    private static boolean[][] visited;
    private static final int[] dx = new int[]{0, 0, 1, -1};
    private static final int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        picture = new char[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            char[] row = reader.readLine().toCharArray();
            for(int j = 0; j < n; j++) {
                picture[i][j] = row[j];
            }
        }

        int notRedGreen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    notRedGreen++;
                    bfs(i, j, false);
                }
            }
        }

        int redGreen = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    redGreen++;
                    bfs(i, j, true);
                }
            }
        }

        System.out.println(notRedGreen + " " + redGreen);
    }

    private static void bfs(int i, int j, boolean redGreen) {
        visited[i][j] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            int x = location[0];
            int y = location[1];

            for (int point = 0; point < 4; point++) {
                int nextX = x + dx[point];
                int nextY = y + dy[point];
                boolean checked = redGreen ? checkRedGreenCondition(x, y, nextX, nextY) : checkCondition(x, y, nextX, nextY);
                if (checked) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    private static boolean checkCondition(int x, int y, int nextX, int nextY) {
        return nextX >= 0 && nextX < n && nextY >= 0 && nextY < n
                && !visited[nextX][nextY]
                && picture[x][y] == picture[nextX][nextY];
    }

    private static boolean checkRedGreenCondition(int x, int y, int nextX, int nextY) {
        return nextX >= 0 && nextX < n && nextY >= 0 && nextY < n
                && !visited[nextX][nextY]
                && (picture[x][y] != 'B' && picture[nextX][nextY] != 'B' || picture[x][y] == 'B' && picture[nextX][nextY] == 'B');
    }
}
