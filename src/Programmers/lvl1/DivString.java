package Programmers.lvl1;

import java.util.ArrayList;

public class DivString {
    public static void main(String[] args) {
        System.out.println(solution("abracadabra"));
    }

    public static int solution(String s) {
        ArrayList<String> result = new ArrayList<>();
        int count1;
        int count2;
        int idx = 0;

        while(idx < s.length()) {
            char cur = s.charAt(idx);
            count1 = 0;
            count2 = 0;

            for (int i = idx; i < s.length(); i++) {
                if (cur == s.charAt(i)) {
                    count1++;
                } else {
                    count2++;
                }

                if (count1 == count2) {
                    result.add(s.substring(idx));
                    idx = i + 1;
                    break;
                }

                if (i == s.length() - 1) {
                    result.add(s.substring(idx));
                    idx = s.length();
                }
            }
        }

        return result.size();
    }
}
