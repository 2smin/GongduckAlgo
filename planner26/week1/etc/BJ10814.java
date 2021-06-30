package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10814 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static Member[] list;
    static Member[] sorted;

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        list = new Member[total];
        sorted = new Member[total];

        for(int i=0; i<total; i++){
            String[] input = bf.readLine().split(" ");
            Member member = new Member(Integer.valueOf(input[0]),input[1]);
            list[i] = member;
        }

        merge(list, 0, total-1);

        for(int i=0; i<list.length; i++){
            sb.append(list[i].toString()).append("\n");
        }

        System.out.println(sb);
    }

    public static void merge(Member[] arr, int start, int end){

        if(start<end){
            int middle = (start+end)/2;
            merge(arr,start,middle);
            merge(arr,middle+1,end);
            mergeSort(arr,start,middle,end);
        }

    }

    public static void mergeSort(Member[] arr, int start, int middle, int end){

        int m = start;
        int n = middle+1;
        int k = start;

        while(m <= middle && n <= end){

            if(arr[m].getAge() <= arr[n].getAge()){
                sorted[k] = arr[m];
                m++;
            }else{
                sorted[k] = arr[n];
                n++;
            }

            k++;
        }

        if(m > middle){
            for(int t=n; t<=end; t++){
                sorted[k] = arr[t];
                k++;
            }
        }else{
            for(int t=m; t<=middle; t++){
                sorted[k] = arr[t];
                k++;
            }
        }

        for(int t=start; t<=end; t++){
            arr[t] = sorted[t];
        }
    }

}

class Member {

    private int age;
    private String name;

    public Member(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return age + " " + name;
    }

}
