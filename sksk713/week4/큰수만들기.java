package sksk713.week4;

public class 큰수만들기 {

    public static void main(String[] args) {
        String s = "1924";
        boolean[] visit = new boolean[s.length()];
        int k = 2;
        System.out.println(solution(s, k));
    }

    static String solution(String number, int k) {
        boolean[] visit = new boolean[number.length()];
        StringBuilder result = new StringBuilder();

        int index = 0;
        int option = 0;
        for (int i = 0; i < number.length() - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = index; j < (k + 1) + option; j++) {
                if (!visit[j] && max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    if (max == 9) {
                        index = j;
                        break;
                    }
                    index = j;
                }
            }
            visit[index] = true;
            option++;
            result.append(max);
        }

        return result.toString();
    }
}
