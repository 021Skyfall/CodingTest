package baekjoon.수학;

import java.util.Scanner;

public class BJ_31798 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a == 0) {
            System.out.println((int)(c * c - b));
        } else if (b == 0) {
            System.out.println((int)(c * c - a));
        } else if (c == 0) {
            System.out.println((int)Math.sqrt(a + b));
        }

        scanner.close();
    }
}
