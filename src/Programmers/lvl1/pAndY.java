package Programmers.lvl1;

public class pAndY {
    public static void main(String[] args) {
        String test1 = "pPoooyY";
        String test2 = "Pyy";

        System.out.println(solution(test1)); // true
        System.out.println(solution(test2)); // false
    }

    public static boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;

        // 문자열을 소문자로 변환하여 대소문자 구분 없이 비교
        s = s.toLowerCase();

        // 문자열을 순회하면서 'p'와 'y'의 개수를 카운트
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') {
                pCount++;
            } else if (s.charAt(i) == 'y') {
                yCount++;
            }
        }

        // 'p'와 'y'의 개수가 같은지 비교
        return pCount == yCount;
    }
}
