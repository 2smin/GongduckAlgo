import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/**
 * https://www.acmicpc.net/problem/14502
 *
 * 연구소
 */
public class Baekjoon14502 {

    private static int colCount;
    private static int rowCount;
    private static int[][] map;
    private static int max = 0;
    private static boolean[][] check;
    private static final int[] dx = new int[]{0, 0, 1, -1};
    private static final int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] count = reader.readLine().split(" ");
        colCount = Integer.parseInt(count[0]);
        rowCount = Integer.parseInt(count[1]);

        map = new int[colCount][rowCount];
        for (int i = 0; i < colCount; i++) {
            String[] values = reader.readLine().split(" ");
            for (int j = 0; j < rowCount; j++) {
                map[i][j] = Integer.parseInt(values[j]);
            }
        }

        addWall(0);

        System.out.println(max);
    }

    private static void addWall(int wall) {
        if (wall == 3) {
            bfs();
            max = Math.max(max, getSafeCount());

            return;
        }

        for (int i = 0; i < colCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    addWall(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        check = new boolean[colCount][rowCount];

        for (int i = 0; i < colCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                if (map[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    check[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            int currentCol = location[0];
            int currentRow = location[1];

            for (int i = 0; i < 4; i++) {
                int col = currentCol + dx[i];
                int row = currentRow + dy[i];
                if (col >= 0 && col < colCount && row >= 0 && row < rowCount
                        && !check[col][row] && map[col][row] == 0) {
                    check[col][row] = true;
                    queue.add(new int[]{col, row});
                }
            }
        }
    }

    private static int getSafeCount() {
        int count = 0;
        for (int i = 0; i < colCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                if (map[i][j] == 0 && !check[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
