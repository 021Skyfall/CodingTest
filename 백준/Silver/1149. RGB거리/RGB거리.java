import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[][] cost = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = scanner.nextInt();
            }
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + cost[i][0], dp[i - 1][2] + cost[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + cost[i][1], dp[i - 1][2] + cost[i][1]);
            dp[i][2] = Math.min(dp[i - 1][0] + cost[i][2], dp[i - 1][1] + cost[i][2]);
        }

        int result = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        System.out.println(result);
        
        scanner.close();
    }
}