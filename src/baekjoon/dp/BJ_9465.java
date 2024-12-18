package baekjoon.dp;

import java.util.Scanner;

public class BJ_9465 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[][] arr = new int[2][N];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            int[][] DP = new int[2][N];

            // 스티커 길이가 1일 경우
            DP[0][0] = arr[0][0];
            DP[1][0] = arr[1][0];
            if (N == 1) {
                System.out.println(Math.max(DP[0][0], DP[1][0]));
                continue;
            }

            // 스티커 길이가 2일 경우
            DP[0][1] = arr[1][0] + arr[0][1];
            DP[1][1] = arr[0][0] + arr[1][1];
            if (N == 2) {
                System.out.println(Math.max(DP[0][1], DP[1][1]));
                continue;
            }

            // 스티커 길이가 3이상일 경우
            for (int i = 2; i < N; i++) {
                DP[0][i] = Math.max(DP[1][i - 2], DP[1][i - 1]) + arr[0][i];
                DP[1][i] = Math.max(DP[0][i - 2], DP[0][i - 1]) + arr[1][i];
            }

            System.out.println(Math.max(DP[0][N - 1], DP[1][N - 1]));
        }

        scanner.close();
    }
}