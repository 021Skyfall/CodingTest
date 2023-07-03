package coplit;

//두 문자열을 입력받아 다음의 조건을 만족하는 LCS*의 길이를 리턴해야 합니다.
//
//LCS: 두 문자열에 공통으로 존재하는 연속되지 않는 부분 문자열(Longest Common Subsequence)
//문자열 "abc"의 subseqeunce는 "a", "b", "c", "ab", "ac", "bc", "abc" 입니다.

//LCS의 길이를 리턴해야 합니다.
//LCS가 존재하지 않는 경우, 0을 리턴해야 합니다.

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        int output = LCS("abcd", "aceb");
        System.out.println(output); // --> 2 ("ab" or "ac")

        output = LCS("acaykp", "capcak");
        System.out.println(output); // --> 4 ("acak")
    }
    // O(M+N)
    private static int LCS(String str1, String str2) {
        // memoization 을 활용해 중복 계산 문제 제거
        int M = str1.length();
        int N = str2.length();
        // 중복 계산 방지용 left, right
        int[][] memo = new int[M+1][N+1];
        for (int[] data : memo) Arrays.fill(data, -1);

        return compareOneByOne(0,0,0,memo,str1,str2);
    }
    private static int compareOneByOne(int left, int right, int len, int[][] memo, String str1, String str2) {
        if (memo[left][right] != -1) return memo[left][right];

        if (left == str1.length() || right == str2.length()) return 0;

        if (str1.charAt(left) == str2.charAt(right)) {
            memo[left][right] = 1 + compareOneByOne(left + 1, right + 1, len + 1, memo, str1, str2);
            return memo[left][right];
        }

        memo[left][right] = Math.max(
                compareOneByOne(left + 1, right, len, memo, str1, str2),
                compareOneByOne(left, right + 1, len, memo, str1, str2)
        );
        return memo[left][right];
    }
}
