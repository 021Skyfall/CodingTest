package Programmers.lvl1;

import java.util.Arrays;
import java.util.Comparator;

public class StringMySort {
    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1; // 기준 인덱스
        String[] sortedStrings = solution(strings, n);

        // 결과 출력
        System.out.println(Arrays.toString(sortedStrings));
    }

    public static String[] solution(String[] strings, int n) {
        // 문자열 배열을 정렬
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // n번째 인덱스의 문자를 기준으로 비교
                if (s1.charAt(n) != s2.charAt(n)) {
                    return Character.compare(s1.charAt(n), s2.charAt(n));
                }
                // n번째 문자가 같으면 사전 순으로 비교
                return s1.compareTo(s2);
            }
        });

        return strings;
    }
}
