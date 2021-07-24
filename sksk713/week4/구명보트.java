package sksk713.week4;

import java.util.*;

class 구명보트 {
    public static void main(String[] args) {
        int[] a = {70, 80, 50};
        int limit = 100;
        System.out.println(solution(a, limit));
    }
    static int solution(int[] people, int limit) {
        boolean[] visit = new boolean[people.length];
        int cnt = 0;
        int x = limit;

        Arrays.sort(people);
        int flag = 0;
        int j = people.length - 1;

        for (int i = 0; i < people.length; i++) {
            if (visit[i]) {
                continue;
            }
            if (limit - people[i] < people[i]) {
                visit[i] = true;
                cnt++;
                continue;
            }
            limit = x;
            flag = 0;

            for (; j > i; j--) {
                if (visit[j]) {
                    continue;
                }
                if (limit >= (people[i] + people[j])) {
                    visit[i] = true;
                    visit[j] = true;
                    flag = 1;
                    cnt++;
                    break;
                }
                visit[j] = true;
                cnt++;
            }
            if (flag != 1) {
                visit[i] = true;
                cnt++;
            }
        }
        return cnt;
    }
}