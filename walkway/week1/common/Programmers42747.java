import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 *
 * H-Index
 * Category: Sorting
 */
class Programmers42747 {

    public int solution(int[] citations) {
        Arrays.sort(citations);

        int result = 0;
        for (int i = 0; i < citations.length; i++) {
            int hindex = citations.length - i;

            if (citations[i] >= hindex) {
                return hindex;
            }
        }

        return result; dlsdyd ehls

    }
}