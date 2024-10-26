package baekjoon.문자열;

import java.util.Scanner;

public class InsertParentheses_11899 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        while (s.contains("()")) {
            s = s.replace("()", "");
        }

        System.out.println(s.length());

        scanner.close();
    }
}
