package baekjoon.경로;

import java.util.Scanner;

public class BJ_2343 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];

        long r = 0; // 최대값 r은 모든 배열의 합
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            r += arr[i];
        }

        long l = 0; // 최소값 l은 0으로 초기화
        for (int i = 0; i < n; i++) {
            l = Math.max(l, arr[i]); // l은 배열의 max값
        }

        while (l <= r) {
            long mid = (l + r) / 2; // 현재 블루레이 길이

            long sum = 0;
            int cnt = 0; // mid일때 블루레이 수 구하기
            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += arr[i];
            }
            if (sum != 0) cnt++; // 마지막 블루레이 추가

            // 블루레이 수와 m 비교하여 l, r 값 조정하기
            if (cnt > m) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(l);
        scanner.close();
    }
}
