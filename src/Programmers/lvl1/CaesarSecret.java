package Programmers.lvl1;

public class CaesarSecret {
    public static void main(String[] args) {
        // 테스트 케이스
        System.out.println(solution("AB", 1)); // "BC"
        System.out.println(solution("z", 1)); // "a"
        System.out.println(solution("a B z", 4)); // "e F d"
    }

    public static String solution(String s, int n) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char shifted = (char) ('A' + (c - 'A' + n) % 26);
                result.append(shifted);
            } else if (Character.isLowerCase(c)) {
                char shifted = (char) ('a' + (c - 'a' + n) % 26);
                result.append(shifted);
            } else {
                result.append(c); // 공백 처리
            }
        }

        return result.toString();
    }
}
