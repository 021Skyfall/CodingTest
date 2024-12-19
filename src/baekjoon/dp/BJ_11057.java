package baekjoon.dp;

import java.util.Scanner;

public class BJ_11057 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MOD = 10007;

        int N = scanner.nextInt();

        int[][] arr = new int[1001][10];

        for (int i = 0; i < 10; i++) {
            arr[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                arr[i][j] = 0;
                for (int k = 0; k <= j; k++) {
                    arr[i][j] += arr[i - 1][k];
                    arr[i][j] %= MOD;
                }
            }
        }

        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result += arr[N][i];
        }

        System.out.println(result % MOD);
        scanner.close();
    }
}
