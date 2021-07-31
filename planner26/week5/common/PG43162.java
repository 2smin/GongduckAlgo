package programmers;

public class PG43162 {

    public static void main(String[] args) {

        int[][] computer = {{1,1,0},{1,1,1},{0,1,1}};
        int answer = solution(3,computer);

        System.out.println("answer: " + answer);
    }

    public static int solution(int n, int[][] computers) {

        int answer = 0;

        boolean[] checked = new boolean[computers.length];

        for(int i=0; i<computers.length; i++){
            if(!checked[i]){
                DFS(i,computers,checked);
                answer++;
            }
        }

        return answer;
    }

    public static void DFS(int num, int[][] computer, boolean[] checked){

        //map에서 num에 해당하는 줄을 체크한다.
        //그 줄에서 본인과 다른index를 가지고 1인이며 false인 얘들을 cheked true 로 바구고 dfs 실행한다.

        for(int i=0; i< computer[num].length; i++){

            if(i == num)continue;
            if(!checked[i] && computer[num][i]==1){

                checked[i] = true;
                DFS(i,computer,checked);
            }
        }
    }
}


