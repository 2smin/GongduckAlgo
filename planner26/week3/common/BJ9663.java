package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9663 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] col;
    static int count;

    public static void main(String[] args) throws IOException {

        N = Integer.valueOf(bf.readLine());
        col = new int[N+1];

        for(int i=1; i<=N; i++){
            col[1] = i;
            dfs(col,1);
        }

        System.out.println(count);
    }

    static void dfs(int[] col, int row){

        if(row == N){
            count++;
        }else{

            for(int i=1; i<=N; i++){
                col[row+1] = i;
                if(isPossible(col, row+1)){
                    dfs(col,row+1);
                }
            }
        }
    }

    static boolean isPossible(int[] col, int row){

        for(int i=1; i<row; i++){
            if(col[i] == col[row]){return false;}
            if(Math.abs(i-row) == Math.abs(col[i] - col[row])){return false;}
        }
        return true;
    }

}
