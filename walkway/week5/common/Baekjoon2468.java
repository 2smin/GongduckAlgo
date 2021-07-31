import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2468
 *
 * 안전 영역
 */
public class Baekjoon2468 {
    private static int n;
    private static int[][] area;
    private static boolean[][] visited;
    private static final int[] dx = new int[]{0, 0, 1, -1};
    private static final int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        area = new int[n][n];

        int maxValue = 0;
        for(int i = 0; i < n; i++) {
            String[] row = reader.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(row[j]);
                maxValue = Math.max(maxValue, area[i][j]);

            }
        }

        int height = 0;
        int safeMaxCount = 0;
        while (height <= maxValue) {
            visited = new boolean[n][n];
            int heightCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && area[i][j] > height) {
                        heightCount++;
                        dfs(i, j, height);
                    }
                }
            }
            safeMaxCount = Math.max(safeMaxCount, heightCount);
            height++;
        }

        System.out.println(safeMaxCount);
    }

    private static void dfs(int x, int y, int depth) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
                if (area[nextX][nextY] > depth && !visited[nextX][nextY])
                    dfs(nextX, nextY, depth);
            }
        }
    }
}
