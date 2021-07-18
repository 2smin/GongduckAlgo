/**
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 *
 * 카펫
 */
class Programmers42842 {
    public static void main(String args[]) {
        int[] result = solution(10, 2);
        System.out.println(result[0] + ", " + result[1]);
    }

    public static int[] solution(int brown, int yellow) {
        int area = brown + yellow;
        for (int height = 1; height < area; height++) {
            int width = area / height;
            if (2 * width + 2 * height - 4 == brown && (width - 2) * (height - 2) == yellow) {
                return new int[] { width, height };
            }
        }
        return new int[]{};
    }
}