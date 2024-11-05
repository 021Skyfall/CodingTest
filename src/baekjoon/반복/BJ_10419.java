package baekjoon.반복;

import java.util.Scanner;

public class BJ_10419 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int d = scanner.nextInt();
            for (int j = 0; j <= 10000; j++) {
                if (j + j * j > d) {
                    System.out.println(j - 1);
                    break;
                }
            }
        }

        scanner.close();
    }
}
