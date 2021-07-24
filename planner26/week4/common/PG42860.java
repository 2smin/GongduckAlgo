package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class PG42860 {
    //문제에 오류??
    public static void main(String[] args) {

        String name = "JAN";
        int middle = 14;

        char[] arr = new char[name.length()];
        for(int i=0; i<name.length(); i++){
            arr[i] = name.charAt(i);
        }

        String fin = "";
        int count = 0;

        for(int i=0; i<name.length(); i++){ fin+= "A";}

        for(int i=0; i<name.length(); i++){
            System.out.println(arr[i]);
            System.out.println(fin.charAt(i));
            System.out.println(arr[i] - fin.charAt(i));

            int num = arr[i] - fin.charAt(i);

            if(num == 0){
                i++;
            }else if(num <= middle){
                count+= num;
            }else if(num > middle){
                count+= 26-num;
            }
        }

        count+= name.length()-1;

        System.out.println(count);

        int length = name.length()-1;
        int start = 0;

        ArrayList<Integer> indexList = new ArrayList<>();

        for(int i=arr.length-1; i>=0; i--){

            if(arr[i] != 65){
                count-=i;
            }
        }

        System.out.println(count);






    }
}
