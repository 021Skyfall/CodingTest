package baekjoon.수학;

import java.util.Scanner;

public class Frog_25333 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int a = scanner.nextInt(); // 우측 점프 거리
            int b = scanner.nextInt(); // 좌측 점프 거리
            int x = scanner.nextInt(); // 목표 거리

            System.out.println(x / gcd(a, b));
        }

        scanner.close();
    }

    // GCD
    public static int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}
