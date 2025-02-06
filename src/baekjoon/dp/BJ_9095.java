package baekjoon.dp;

import java.util.Scanner;

public class BJ_9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[] dp = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                if (i == 1) {
                    dp[i] = 1;
                } else if (i == 2) {
                    dp[i] = 2;
                } else if (i == 3) {
                    dp[i] = 4;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                }
            }

            System.out.println(dp[N]);
        }
        sc.close();
    }
}