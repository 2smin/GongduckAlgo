package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2108 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int arr[];

    static Comparator<Map.Entry<Integer,Integer>> mapSort = new Comparator<Map.Entry<Integer,Integer>>(){

        @Override
        public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {

            if(o1.getValue() > o2.getValue()){
                return -1;
            }else if(o1.getValue() < o2.getValue()){
                return  1;
            }else{
                if(o1.getKey() > o2.getKey()){
                    return 1;
                }else{
                    return -1;
                }
            }
        }
    };

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        arr = new int[total];
        for(int i=0; i<total; i++){
            int num = Integer.valueOf(bf.readLine());
            arr[i] = num;
        }

        Arrays.sort(arr);

        System.out.println(average(arr));
        System.out.println(medium(arr));
        System.out.println(most(arr));
        System.out.println(diffrentiation(arr));

    }

//  QuickSort로 하면 시간 초과가 나온다..?
//    public static void qSort(int[]arr, int start, int end){
//
//        if(start >= end){
//            return;
//        }
//        int pivot = start;
//        int m = start+1;
//        int n = end;
//        int tmp = 0;
//
//        while(m<=n){
//
//            while(m <= end && arr[m] <= arr[pivot]){m++;}
//            while(n > start && arr[n] >= arr[pivot]){n--;}
//
//            if(m>n){
//                tmp = arr[n];
//                arr[n] = arr[pivot];
//                arr[pivot] = tmp;
//            }else{
//                tmp = arr[m];
//                arr[m] = arr[n];
//                arr[n] = tmp;
//
//            }
//        }
//
//        qSort(arr,start,n-1);
//        qSort(arr, n+1, end);
//    }

    public static int average(int[] arr){
        double sum = 0;
        for(int i : arr){ sum+= i; }
        return (int)Math.round(sum/arr.length);
    }

    public static int medium(int[] arr){
        return arr[arr.length/2];
    }

    public static int most(int[] arr){

        if(arr.length > 1){

            HashMap<Integer,Integer> map = new HashMap<>();

            for(int i=0; i<arr.length; i++){
                if(map.containsKey(arr[i])){
                    map.put(arr[i],map.get(arr[i])+1);
                }else{
                    map.put(arr[i],1);
                }
            }

            List<Map.Entry<Integer,Integer>> mapToList = new ArrayList<>(map.entrySet());
            Collections.sort(mapToList, mapSort);

            Map.Entry<Integer,Integer> entry1 = mapToList.get(0);
            Map.Entry<Integer,Integer> entry2 = mapToList.get(1);

            return entry1.getValue() == entry2.getValue() ? entry2.getKey() : entry1.getKey();
        }else{
            return arr[0];
        }
    }

    public static int diffrentiation(int[] arr){

        int size = arr.length;

        if(size > 1){

            return arr[size-1] - arr[0];
        }else{
            return 0;
        }
    }
}
