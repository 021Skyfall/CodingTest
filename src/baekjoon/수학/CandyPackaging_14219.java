package baekjoon.수학;

import java.util.Scanner;

public class CandyPackaging_14219 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 박스의 가로 길이
        int m = scanner.nextInt(); // 박스의 세로 길이

        if ((n * m) % 3 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}