import java.util.*;

public class H_index {

    public static void main(String[] args) {
        int[] citations = {24, 22};

        int answer = 0;

        Arrays.sort(citations);
        Integer[] citationsA = new Integer[citations.length];

        for (int i = 0; i < citations.length; i++) {
            citationsA[i] = citations[i];
        }

        List<Integer> citationsB = Arrays.asList(citationsA);
        Collections.reverse(citationsB);


        for (int i = 0; i < citations.length; i++) {
            if (i + 1 == citationsA[i]) {
                answer = i + 1;
                break;
            }
            else if (i + 1 > citationsA[i]) {
                answer = i;
                break;
            }
            else if (i == citations.length - 1 && i + 1 < citationsA[i]) {
                answer = citations.length;
            }
        }

        System.out.println(answer);
    }
}
