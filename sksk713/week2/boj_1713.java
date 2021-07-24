import java.io.*;
import java.util.*;

public class boj_1713 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> frame = new ArrayList<>();
    static int[] cnt = new int[101];

    public static void main(String[] args) throws IOException {
        int frameCnt = Integer.parseInt(br.readLine());
        int recommend = Integer.parseInt(br.readLine());
        int[] num = new int[recommend];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < recommend; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < recommend; i++) {
            if (frameCnt == 0) {
                if (frame.contains(num[i])) {
                    cnt[num[i]]++;
                    continue;
                }
                // 가장 추천 적은 거 값 뽑기
                int min = Integer.MAX_VALUE;

                for (int j = 0; j < cnt.length; j++) {
                    if (cnt[j] != 0 && min > cnt[j]) {
                        min = cnt[j];
                    }

                }
                for (int j = 0; j < frame.size(); j++) {
                    if (cnt[frame.get(j)] == min) {
                        cnt[frame.get(j)] = 0;
                        frame.remove(j);
                        frame.add(num[i]);
                        cnt[num[i]]++;

                        break;
                    }
                }
            }
            else {
                if (!frame.contains(num[i])) {
                    frame.add(num[i]);
                    cnt[num[i]]++;
                    frameCnt--;
                }
                else {
                    cnt[num[i]]++;
                }
            }

        }

        Collections.sort(frame);
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < frame.size(); i++) {
            answer.append(frame.get(i) + " ");
        }
        System.out.println(answer);

    }
}