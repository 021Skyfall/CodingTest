package Programmers.lvl2;

public class PasswordOfTwo {
    public static void main(String[] args) {
        System.out.println(solution("aukks","wbqd",5));
    }

    public static String solution(String s, String skip, int index) {
        StringBuilder result = new StringBuilder();
        boolean[] skipSet = new boolean[26];

        for (char c : skip.toCharArray()) {
            skipSet[c - 'a'] = true;
        }

        for (char ch : s.toCharArray()) {
            char cur = ch;

            for (int i = 0; i < index; i++) {
                do {
                    cur++;
                    if (cur > 'z')
                        cur = 'a';
                } while (skipSet[cur - 'a']);
            }

            result.append(cur);
        }

        return result.toString();
    }
}
