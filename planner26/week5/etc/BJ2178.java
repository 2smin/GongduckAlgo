package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2178 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] total = bf.readLine().split(" ");

        int N = Integer.valueOf(total[0]);
        int M = Integer.valueOf(total[1]);

        int[][] maze = new int[N][M];

        int line = 0;

        while(line < N){

            String[] input = bf.readLine().split("");
            int[] arr = new int[input.length];

            for(int i=0; i<input.length; i++){ arr[i] = Integer.valueOf(input[i]);}

            maze[line] = arr;
            line++;
        }

        Queue<int[]> queue = new LinkedList<>();
        int[][] checkVisitied = new int[N][M];

        queue.add(new int[]{0,0});
        checkVisitied[0][0] = 1;

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        while(!queue.isEmpty()) {

            int[] point = queue.remove();
            int count = checkVisitied[point[0]][point[1]];

            for(int i=0; i<4; i++){

                int x = point[0] + dx[i];
                int y = point[1] + dy[i];

                if(x<N && x>=0 && y<M && y>=0 && maze[x][y] != 0 && checkVisitied[x][y] == 0){
                    queue.add(new int[]{x,y});
                    checkVisitied[x][y] = count+1;
                }
            }

            if(point[0] == N-1 && point[1] == M-1){ break; }
        }

        System.out.println(checkVisitied[N-1][M-1]);
    }
}
