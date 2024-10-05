import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 줄 입력
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int R = scanner.nextInt();

        int left = X - R;
        int right = X + R;

        int A = 0; // (A: 내부 점 개수)
        int B = 0; // (B: 경계 점 개수)

        // N개의 점 입력
        for (int i = 0; i < N; i++) {
            int v = scanner.nextInt();
            if (v == left || v == right) {
                B++;
            } else if (v > left && v < right) {
                A++;
            }
        }

        System.out.println(A + " " + B);
        scanner.close();
    }
}