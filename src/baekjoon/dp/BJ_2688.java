package baekjoon.dp;

import java.util.Scanner;

public class BJ_2688 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[][] dp = new long[65][10];
        int t, n;

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            long result = 0;
            for (int i = 0; i <= 9; i++) {
                result += dp[n][i];
            }
            System.out.println(result);
        }

        scanner.close();
    }
}
