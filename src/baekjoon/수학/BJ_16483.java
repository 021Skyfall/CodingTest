package baekjoon.수학;

import java.util.Scanner;

public class BJ_16483 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        float half = (float) T / 2.0f;
        System.out.println(Math.round(half * half));
        scanner.close();
    }
}
