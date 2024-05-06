import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 우선순위 큐

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                pq.offer(Integer.parseInt(input[j]));
            }
        }

        // N번째까지의 큰 수를 찾기 위해 N-1번 poll 호출
        for(int i = 0; i < N - 1; i++) {
            pq.poll();
        }

        // N번째로 큰 수 출력
        System.out.println(pq.poll());
    }
}