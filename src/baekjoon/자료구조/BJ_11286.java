package baekjoon.자료구조;

import java.util.*;

public class BJ_11286 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // (절대값, 원래 값) 쌍을 저장하는 최소 힙
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // 절대값이 같으면 원래 값으로 비교
            }
            return a[0] - b[0]; // 절대값 기준으로 비교
        });

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            if (a != 0) {
                q.offer(new int[]{Math.abs(a), a}); // 절대값과 원래 값을 저장
            } else {
                if (q.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(q.poll()[1]); // 원래 값을 출력
                }
            }
        }

        scanner.close();
    }
}
