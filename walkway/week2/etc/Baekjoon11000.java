import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/submit/11000
 *
 * 강의실 배정
 */
public class Baekjoon11000 {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(reader.readLine());
        LinkedList<Study> studies = new LinkedList<>();
        for (int i = 0; i < inputCount; i++) {
            String[] input = reader.readLine().split(" ");
            studies.add(new Study(Integer.valueOf(input[0]), Integer.valueOf(input[1])));
        }

        studies.sort((o1, o2) -> {
            int compare = o1.startTime - o2.startTime;
            if (compare == 0) {
                return o1.endTime - o2.endTime;
            }
            return compare;
        });

        PriorityQueue<Study> endQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.endTime));

        for (int i=0; i < inputCount; i++) {
            if (!endQueue.isEmpty() && endQueue.peek().endTime  <= studies.peek().startTime) {
                endQueue.poll();
            }
            endQueue.add(studies.poll());
        }

        System.out.println(endQueue.size());
    }

    private static class Study {
        int startTime;
        int endTime;

        Study(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}