package baekjoon.수학;

import java.util.Scanner;

public class BinaryProblem_14723 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int i = 1;

        // 삼각수가 n보다 작을 때까지 i 증가
        while (i * (i + 1) / 2 < n) {
            i++;
        }

        int b = n - (i - 1) * i / 2; // b 계산
        int a = i + 1 - b;           // a 계산

        // 결과 출력
        System.out.println(a + " " + b);

        scanner.close();
    }
}
