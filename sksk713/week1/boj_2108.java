import java.util.*;

public class boj_2108 {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> arr = new ArrayList<>();
    static int[] answer;

    public static void main(String[] args) {
        int testCase = Integer.parseInt(sc.nextLine());

        answer = new int[testCase];

        for (int i = 0; i < testCase; i++) {
            int input = sc.nextInt();
            arr.add(input);
            answer[i] = input;
        }

        Collections.sort(arr);

        System.out.println(average());
        System.out.println(median());
        System.out.println(frequent());
        System.out.println(gap());
    }

    static int average() {
        int sum = 0;

        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }

        if (sum >= 0) {
            return (int)Math.round((double) sum / arr.size());
        }
        else {
            return (int)-Math.round((double) (-sum) / arr.size());
        }
    }

    static int median() {

        return arr.get((arr.size() - 1) / 2);
    }

    static int frequent() {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            map.put(answer[i], map.getOrDefault(answer[i], 0) + 1);
        }

        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            if (x.getValue() > maxValue) {
                maxValue = x.getValue();
            }
        }

        TreeMap<Integer, Integer> sortMap = new TreeMap(map);

        int max = Integer.MIN_VALUE;
        int result = 0;
        for (Map.Entry<Integer, Integer> x : sortMap.entrySet()) {
            if (x.getValue() > max) {
                max = x.getValue();
                result = x.getKey();
            }
            else if (x.getValue() == max && x.getValue() == maxValue) {
                return x.getKey();
            }
        }
        return result;

    }

    static int gap() {
        if (arr.size() == 1) {
            return 0;
        }
        else
            return arr.get(arr.size() - 1) - arr.get(0);
    }
}
