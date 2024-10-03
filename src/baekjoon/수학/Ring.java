package baekjoon.수학;

import java.util.Scanner;

public class Ring {
    static int n;
    static int[] radius = new int[101];

    static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    static void solution() {
        for (int i = 1; i < n; i++) {
            int gcd = GCD(radius[0], radius[i]);
            if (gcd == 1)
                System.out.println(radius[0] + "/" + radius[i]);
            else
                System.out.println(radius[0] / gcd + "/" + radius[i] / gcd);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++)
            radius[i] = scanner.nextInt();
        solution();
    }
}
