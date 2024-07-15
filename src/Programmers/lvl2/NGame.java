package Programmers.lvl2;

public class NGame {
    public static void main(String[] args) {
        // 테스트 케이스
        System.out.println(solution(2, 4, 2, 1)); // "0111"
        System.out.println(solution(16, 16, 2, 1)); // "02468ACE11111111"
        System.out.println(solution(16, 16, 2, 2)); // "13579BDF01234567"
    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder sequence = new StringBuilder();
        int number = 0;

        // 필요한 길이만큼 숫자 생성
        while (sequence.length() < t * m) {
            sequence.append(Integer.toString(number++, n).toUpperCase());
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t; i++) {
            result.append(sequence.charAt(i * m + p - 1));
        }

        return result.toString();
    }
}
