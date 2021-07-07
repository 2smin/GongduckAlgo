import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<task> qu = new PriorityQueue<>();

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1[0] < o2[0]) {
                    return -1;
                }
                else if (o1[0] == o2[0]) {
                    if (o1[1] < o2[1]) {
                        return -1;
                    }
                }
                return 0;
            }
        });

        int delay = 0;
        int timer = 0;
        int block = 0;
        int jobCnt = jobs.length;

        int cnt = 0;

        while (true) {
            for (int i = 0; i < jobs.length; i++) {
                if (timer == jobs[i][0]) {
                    qu.offer(new task(jobs[i][1], jobs[i][0]));
                    jobCnt--;
                }
                else if (jobCnt == 0)
                    break;
            }

            while (block == 0 && !qu.isEmpty()) {
                task x = qu.poll();
              
                if (timer > x.start) {
                    delay += (timer - x.start);
                }
                cnt += x.weight;
                block = x.weight;
            }

            if (block == 0 && jobCnt == 0 && qu.isEmpty()) {
                break;
            }

            timer++;
            
            if (block != 0) {
                block--;
            }

        }
        return Math.round((cnt + delay) / jobs.length);
    }
}

class task implements Comparable<task> {
    int weight;
    int start;

    public task(int weight, int start) {
        this.weight = weight;
        this.start = start;
    }
    @Override
    public int compareTo(task task) {
        if (this.weight > task.weight)
            return 1;
        else
            return -1;
    }
}