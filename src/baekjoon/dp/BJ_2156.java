package baekjoon.dp;

import java.util.Scanner;

public class BJ_2156 {
    static final int max = 10010;
    static int n;
    static int[] arr = new int[max];
    static int[] dp = new int[max];

    public static void main(String[] args) {
        Input();
        Solution();
    }

    static int FindMax(int a, int b) {
        return Math.max(a, b);
    }

    static void Input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    static void Solution() {
        dp[1] = arr[1];
        if (n > 1) {
            dp[2] = dp[1] + arr[2];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = FindMax(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
            dp[i] = FindMax(dp[i - 1], dp[i]);
        }
        System.out.println(dp[n]);
    }
}
