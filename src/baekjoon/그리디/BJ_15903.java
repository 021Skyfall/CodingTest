package baekjoon.그리디;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_15903 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 최소 힙을 위한 PriorityQueue 생성
        PriorityQueue<Long> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            long a = scanner.nextLong();
            q.add(a);
        }

        while (m-- > 0) {
            long a = q.poll(); // 가장 작은 값 꺼내기
            long b = q.poll(); // 두 번째로 작은 값 꺼내기
            long sum = a + b; // 두 값을 더하기
            q.add(sum); // 더한 값을 다시 추가
            q.add(sum); // 더한 값을 다시 추가
        }

        long totalSum = 0;
        while (!q.isEmpty()) {
            totalSum += q.poll(); // 모든 값을 더하기
        }

        System.out.println(totalSum);
        scanner.close();
    }
}
