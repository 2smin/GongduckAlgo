import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 *
 * 디스크 컨트롤러
 * Category: Heap
 */
class Programmers42627 {
    public static void main(String args[]) {
        int[][] jobs = new int[][] {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        LinkedList<Job> waiting = new LinkedList<>();
        PriorityQueue<Job> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.workingTime));

        for(int[] job : jobs) {
            waiting.add(new Job(job[0], job[1]));
        }

        Collections.sort(waiting, Comparator.comparingInt(o -> o.inTime));

        int total = 0;
        int count = 0;
        int time = waiting.peek().inTime;
        while(count < jobs.length) {
            while(!waiting.isEmpty() && waiting.peek().inTime <= time) {
                heap.add(waiting.poll());
            }

            if(!heap.isEmpty()) {
                Job job = heap.poll();
                time += job.workingTime;
                total += time - job.inTime;
                count++;
            } else {
                time++;
            }
        }

        return total / count;
    }

    private static class Job {
        int inTime;
        int workingTime;

        Job(int inTime, int workingTime){
            this.inTime = inTime;
            this.workingTime = workingTime;
        }
    }
}