package baekjoon.dp;

import java.util.Scanner;

public class BJ_1890 {
    static final int max = 102;
    static int[][] board = new int[max][max];
    static long[][] dp = new long[max][max];
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(move(0, 0));
        scanner.close();
    }

    public static long move(int x, int y) {
        if (x == n - 1 && y == n - 1) return 1;
        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        int jump = board[x][y];

        // 우측 이동
        if (y != n - 1 && y + jump < n) {
            dp[x][y] += move(x, y + jump);
        }
        // 하단 이동
        if (x != n - 1 && x + jump < n) {
            dp[x][y] += move(x + jump, y);
        }

        return dp[x][y];
    }
}
