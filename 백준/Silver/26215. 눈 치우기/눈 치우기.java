import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        while (!pq.isEmpty()) {
            int firstMax = pq.poll(); // 가장 눈이 많이 쌓인 집
            int secondMax = 0;

            if (!pq.isEmpty()) {
                secondMax = pq.poll(); // 두 번째로 눈이 많이 쌓인 집
            }

            // 두 집의 눈을 1씩 치우기
            firstMax--;
            if (secondMax > 0) {
                secondMax--;
            }

            // 아직 눈이 남아있다면 다시 우선순위 큐에 추가
            if (firstMax > 0) {
                pq.offer(firstMax);
            }
            if (secondMax > 0) {
                pq.offer(secondMax);
            }

            // 시간 증가
            time++;

            // 24시간 초과 체크
            if (time > 1440) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(time);
    }
}