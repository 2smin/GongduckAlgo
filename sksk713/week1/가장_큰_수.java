import java.util.*;

public class 가장_큰_수 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] x = {898, 89};
        Arrays.sort(x);

        StringBuilder[] stringBuilders = new StringBuilder[x.length];

        for (int i = 0; i < x.length; i++) {
            StringBuilder sb = new StringBuilder(Integer.toString(x[i]));
            stringBuilders[i] = sb;
        }

        Arrays.sort(stringBuilders, new Comparator<StringBuilder>() {
            @Override
            public int compare(StringBuilder o1, StringBuilder o2) {

                for (int i = 0; i < x.length; i++) {
                    System.out.print(stringBuilders[i] + " ");
                }
                System.out.println();

                String st1 = o1.toString();
                int x = st1.charAt(0) - '0';

                String st2 = o2.toString();
                int y = st2.charAt(0) - '0';

                System.out.println("x=" + st1 +"y=" + st2);

                if (x > y) {
                    return -1;
                }
                else if (x < y) {
                    return 1;
                }
                else {
                    if (o1.length() < o2.length()) {
                        for (int i = 1; i < o2.length(); i++) {
                            if (i == o1.length()) {
                                int z = st2.charAt(i) - '0';

                                if (x < z) {
                                    return -1;
                                }
                                else if (x == z && Character.getNumericValue(st1.charAt(i - 1)) < x) {
                                    return -1;
                                }
                                else
                                    return 1;
                            }
                            else {

                                int a = st1.charAt(i) - '0';
                                int b = st2.charAt(i) - '0';

                                if (a > b) {
                                    return -1;
                                }
                                else if (a < b)
                                    return 1;
                                else
                                    continue;
                            }
                        }
                    }
                    else if (o1.length() > o2.length()){
                        for (int i = 1; i < o1.length(); i++) {
                            if (i == o2.length()) {
                                int z = st1.charAt(i) - '0';

                                if (x < z) {
                                    return -1;
                                }
                                else if (x == z && Character.getNumericValue(st1.charAt(i - 1)) < x) {
                                    return -1;
                                }
                                else
                                    return 1;
                            }
                            else {
                                int a = st1.charAt(i) - '0';
                                int b = st2.charAt(i) - '0';

                                if (a > b) {
                                    return -1;
                                }
                                else if (a < b)
                                    return 1;
                                else
                                    continue;
                            }

                        }
                    }
                    else {
                        for (int i = 1; i < o1.length(); i++) {
                            int a = st1.charAt(i) - '0';
                            int b = st2.charAt(i) - '0';

                            if (a > b) {
                                return -1;
                            }
                            else if (a < b)
                                return 1;
                            else
                                continue;

                        }
                    }
                }
                return 0;
            }
        });

        StringBuilder answer = new StringBuilder();

        for (StringBuilder sb : stringBuilders) {
            answer.append(sb);
        }
        System.out.println(answer);
    }
}
