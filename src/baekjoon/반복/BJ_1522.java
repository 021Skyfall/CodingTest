package baekjoon.반복;

import java.util.Scanner;

public class BJ_1522 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 문자열 입력
        String s = scanner.nextLine();
        int a = countOccurrences(s, 'a'); // 입력된 str에서의 a의 개수

        // a가 0일 경우 처리
        if (a == 0) {
            System.out.println(0); // 'a'가 없으면 'b'의 개수는 0
            scanner.close();
            return;
        }

        // 원형 문자열 처리
        s += s.substring(0, a - 1);
        int minVal = Integer.MAX_VALUE; // 최솟값

        for (int i = 0; i <= s.length() - a; i++) {
            minVal = Math.min(minVal, countOccurrences(s.substring(i, i + a), 'b'));
        }

        System.out.println(minVal);
        scanner.close();
    }

    // 특정 문자 c의 개수를 세는 메서드
    private static int countOccurrences(String str, char c) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }
}