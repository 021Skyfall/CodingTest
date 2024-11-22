import java.util.Scanner;

public class Main {
    static final int MAX = 1010;
    static int N;
    static int[] Card = new int[MAX];
    static int[] DP = new int[MAX];

    static int Min(int A, int B) {
        return Math.min(A, B);
    }

    static void Input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        for (int i = 1; i <= N; i++) {
            Card[i] = scanner.nextInt();
        }
    }

    static void Solution() {
        DP[1] = Card[1];
        for (int i = 2; i <= N; i++) {
            DP[i] = Card[i];
            for (int j = 1; j <= i; j++) {
                DP[i] = Min(DP[i], DP[i - j] + Card[j]);
            }
        }
        System.out.println(DP[N]);
    }

    public static void main(String[] args) {
        Input();
        Solution();
    }
}