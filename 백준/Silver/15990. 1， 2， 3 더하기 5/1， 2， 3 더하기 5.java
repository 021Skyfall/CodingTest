import java.util.Scanner;

public class Main {
    static final int mod = 1000000009;
    static final int max = 100000;
    static long[][] dp = new long[max + 1][4];
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        solution();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % mod);
        }
        scanner.close();
    }

    static void solution() {
        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
        for (int n = 4; n <= max; n++) {
            if (n - 1 >= 0) {
                dp[n][1] = (dp[n - 1][2] + dp[n - 1][3]) % mod;
            }
            if (n - 2 >= 0) {
                dp[n][2] = (dp[n - 2][1] + dp[n - 2][3]) % mod;
            }
            if (n - 3 >= 0) {
                dp[n][3] = (dp[n - 3][1] + dp[n - 3][2]) % mod;
            }
        }
    }
}