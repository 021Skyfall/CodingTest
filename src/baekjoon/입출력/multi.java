package baekjoon.입출력;

import java.util.Scanner;

public class multi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String b = scanner.next();
        System.out.println(b.charAt(2));
        System.out.println(a * (b.charAt(2) - '0'));
        // 문자로 출력되기 때문에 - '0' 으로 아스키 코드 숫자로 변환
        System.out.println(a * (b.charAt(1) - '0'));
        System.out.println(a * (b.charAt(0) - '0'));
        System.out.println(a * Integer.parseInt(b));
    }
}
