import java.util.Scanner;

public class Main {
    static final int MAX = 1010;
    static int N;
    static int[] DP = new int[MAX];

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
    }

    public static void solution() {
        DP[1] = 0;
        DP[2] = 1;
        DP[3] = 0; 

        for (int i = 4; i <= N; i++) {
            if (DP[i - 1] == 0 || DP[i - 3] == 0) {
                DP[i] = 1;
            } else {
                DP[i] = 0;
            }
        }

        if (DP[N] == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }

    public static void solve() {
        input();
        solution();
    }

    public static void main(String[] args) {
        solve();
    }
}