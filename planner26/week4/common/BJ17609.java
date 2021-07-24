package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ17609 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        while(total-- > 0){
            String arr = bf.readLine();
            int num = pseudoCheck(arr);

            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }

    public static int pseudoCheck(String arr){

        int i = 0;
        int j = arr.length()-1;
        int issimilar = 0;
        while(i<j){

            if(isPseudo(i,j,arr)){
                i++;
                j--;
            }else{
                int iPlus = i, jPlus = j;
                iPlus++;
                while(iPlus<jPlus){
                    if(isPseudo(iPlus,jPlus,arr)){
                        iPlus++;
                        jPlus--;
                    }else{
                        issimilar++;
                        break;
                    }

                }

                iPlus = i;
                jPlus = j;

                jPlus--;

                while(iPlus<jPlus){
                    if(isPseudo(iPlus,jPlus,arr)){
                        iPlus++;
                        jPlus--;
                    }else{
                        issimilar++;
                        break;
                    }

                }

                return issimilar;
            }

        }

        return issimilar;
    }

    public static boolean isPseudo(int i, int j, String arr){

        if(arr.charAt(i) == arr.charAt(j)){
            return true;
        }else{
            return false;
        }
    }
}
