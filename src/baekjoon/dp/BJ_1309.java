package baekjoon.dp;

import java.util.Scanner;

public class BJ_1309 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        if (n >= 1) {
            dp[1] = 3;
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1] * 2) % 9901;
        }

        System.out.println(dp[n]);

        scanner.close();
    }
}
