package baekjoon.분할정복;

import java.util.Scanner;

public class BJ_1629 {
    static int a, b, c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();

        System.out.println(f(b));

        scanner.close();
    }

    static long f(long y) {
        if (y == 1) return a % c;

        long k = f(y / 2) % c;

        if (y % 2 == 0) return (k * k) % c;
        else return (k * k) % c * a % c;
    }
}
