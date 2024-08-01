import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        // 각 숫자의 빈도를 저장할 배열
        int[] countX = new int[10];
        int[] countY = new int[10];

        // X의 각 자리 숫자 빈도 수 세기
        for (char c : X.toCharArray()) {
            countX[c - '0']++;
        }

        // Y의 각 자리 숫자 빈도 수 세기
        for (char c : Y.toCharArray()) {
            countY[c - '0']++;
        }

        // 짝꿍 숫자를 저장할 StringBuilder
        StringBuilder result = new StringBuilder();

        // 9부터 0까지 반복하여 짝꿍 숫자를 만들기
        for (int i = 9; i >= 0; i--) {
            // 두 숫자에서 짝꿍 숫자의 개수는 두 배열의 최소값
            int minCount = Math.min(countX[i], countY[i]);
            for (int j = 0; j < minCount; j++) {
                result.append(i);
            }
        }

        // 결과가 빈 경우
        if (result.length() == 0) {
            return "-1";
        }

        // 결과가 0으로 시작하는 경우
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result.toString();
    }
}