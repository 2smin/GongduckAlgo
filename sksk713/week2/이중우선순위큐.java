import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> minQu = new PriorityQueue<>();
        PriorityQueue<Integer> maxQu = new PriorityQueue<>(Collections.reverseOrder());
        int cnt = 0;

        StringTokenizer st;

        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i]);

            if (st.nextToken().charAt(0) == 'I') {
                int n = Integer.parseInt(st.nextToken());
                minQu.offer(n);
                maxQu.offer(n);
                cnt++;
            }
            else {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) {
                    maxQu.poll();
                    cnt--;
                }
                else {
                    minQu.poll();
                    cnt--;
                }
                
                if (cnt == 0) {
                maxQu.clear();
                minQu.clear();
                }
            }

        }

        answer = new int[2];
        if (cnt <= 0) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        else {
            int max = maxQu.poll();
            int min = minQu.poll();
            answer[0] = max;
            answer[1] = min;
            return answer;
        }

    }
}