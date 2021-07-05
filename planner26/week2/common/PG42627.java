package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PG42627 {

    public static void main(String[] args) {

    }

    public static int solution(int[][] jobs){

        //총 걸린 시간
        int answer = 0;
        //현재 지난 시간
        int time = 0;
        //job에서 꺼낼 index
        int idx = 0;
        int length = jobs.length;

        //여기서 꺼내는게 실행순서가 된다
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);

        //작업이 제공된 시간순서대로 sort
        Arrays.sort(jobs,(o1,o2) -> o1[0] - o2[0]);

        //작업이 다 제공 안됐거나 프로세스가 할일이 없을때
        while(idx < length || !queue.isEmpty()){

            //작업이 다 제공 안되었고 다음 작업이 실행 가능할때
            while(idx < length && jobs[idx][0] <= time){
                queue.offer(jobs[idx++]); //프로세스에 해당 작업을 넣는다
            }

            //프로세스가 할일이 없을때
            if(queue.isEmpty()){
                time = jobs[idx][0]; //다음 작업가능 시간으로 시간을 올린다.
            }else{ //할일 있으면
                int[] nextJob = queue.poll(); //다음 할 일 실행
                answer += time - nextJob[0] + nextJob[1]; //작업 제공되고 실제 실행된 시간을 더해준다
                time += nextJob[1]; //다음 할일이 실행 완료된 시간으로 변경
            }
        }

        return answer/length;
    }
}
