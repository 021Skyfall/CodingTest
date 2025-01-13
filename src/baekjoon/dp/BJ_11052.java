package baekjoon.dp;

import java.util.Scanner;

public class BJ_11052 {
    static final int max = 1000 + 1;
    static int n;
    static int[] arr = new int[max];
    static int[] dp = new int[max];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }

        scanner.close();

        dp[0] = arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
