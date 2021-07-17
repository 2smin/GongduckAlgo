package programmers;

public class PG42842 {

    public static void main(String[] args) {

        solution(24,24);
    }

    public static int[] solution(int brown, int yellow) {

        double b = brown/2 -2;
        double c = Math.sqrt(Math.pow(b,2) - (yellow*4));
        double x = (b+c)/2;
        double y = yellow/x;

        int length = (int)((b+c)/2) + 2;
        int height = (int)(yellow/x) + 2;

        int[] answer = {length,height};
        return answer;
    }
}
