package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2805 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        public static void main(String[] args) throws IOException {

            String[] arr = bf.readLine().split(" ");

            int N = Integer.valueOf(arr[0]);
            int M = Integer.valueOf(arr[1]);

            String[] treeArr = bf.readLine().split(" ");
            int[] trees = new int[N];

            for(int i=0; i<treeArr.length; i++){
                trees[i] = Integer.valueOf(treeArr[i]);
            }

            int start = 0;
            int end = 0;
            int middle = 0;

            for(int i=0; i<trees.length; i++){
                if(trees[i] > end){ end = trees[i]; }
            }

            double sum = 0;
            int replaceMin    = 0;

            while(sum != M){

                sum = 0;
                middle = (end+start)/2;

                for(int i=0; i<trees.length; i++){
                    if(trees[i] >= middle){
                        sum += (double)trees[i] - (double)middle;
                    }
                }

                if(start == middle){
                    if(sum < M){ middle = replaceMin; }
                    break;
                }


                if(sum > M){
                    start = middle;
                    replaceMin = middle;
                }else if(sum < M){
                    end = middle;
                }


            }

            System.out.println(middle);
        }
}
