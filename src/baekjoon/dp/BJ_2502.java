package baekjoon.dp;

import java.util.*;

public class BJ_2502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[d + 1];
        int[] b = new int[d + 1];

        // 초기값 설정
        a[1] = 1;
        a[2] = 0;
        b[1] = 0;
        b[2] = 1;

        // A와 B 배열 채우기
        for (int i = 3; i <= d; i++) {
            a[i] = a[i - 1] + a[i - 2];
            b[i] = b[i - 1] + b[i - 2];
        }

        // 가능한 첫날 값 탐색
        for (int i = 1; i <= k; i++) {
            int spare = k - a[d] * i;
            if (spare >= 0 && spare % b[d] == 0) {
                System.out.println(i);
                System.out.println(spare / b[d]);
                return;
            }
        }
    }
}
