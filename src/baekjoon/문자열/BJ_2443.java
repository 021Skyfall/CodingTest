package baekjoon.문자열;

import java.util.Scanner;

public class BJ_2443 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            // 공백 출력
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // 별 출력
            System.out.println("*".repeat(2 * N - (2 * i + 1)));
        }

        scanner.close();
    }
}
