import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] dp = new int[n][n];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }

        int maxSum = dp[n - 1][0];
        for (int j = 1; j < n; j++) {
            maxSum = Math.max(maxSum, dp[n - 1][j]);
        }
        System.out.println(maxSum);
        scanner.close();
    }
}