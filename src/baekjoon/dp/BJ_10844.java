package baekjoon.dp;

import java.util.Scanner;

public class BJ_10844 {
    static final int max = 100 + 1;
    static final int moduler = 1000000000;
    static long answer;
    static long[][] dp = new long[max][11];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        dp[1][0] = 0;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % moduler;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % moduler;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % moduler;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            answer = (answer + dp[N][i]) % moduler;
        }

        System.out.println(answer);
    }
}
