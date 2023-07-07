package coplit;

//문자열을 입력받아 부분 문자열 중 가장 긴 (palindrome)의 길이를 리턴해야 합니다.
//
//palindrome: 데이터를 앞에서 뒤로 또는 뒤에서 앞으로 조회한 결과가 동일한 경우

//문자열 str의 부분 문자열은 자기 자신을 포함합니다.
//공백도 회문에 포함될 수 있습니다.

public class longestPalindrome {
    public static void main(String[] args) {
        String str = "My dad is a racecar athlete";
        int result = longestPalindrome(str);
        System.out.println(result); // --> 11 ('a racecar a')

        str = " dad ";
        result = longestPalindrome(str);
        System.out.println(result); // --> 5 (' dad ')
    }
    private static int longestPalindrome(String str) {
        // edge
        if (str.length() < 2) return str.length();

        int LENG = str.length();
        boolean[][] isPalindrome = new boolean[LENG][];
        for (int i = 0; i < isPalindrome.length; i++) {
            isPalindrome[i] = new boolean[LENG];
        }

        int maxLen = 1;
        // 길이가 1인 회문
        for (int i = 0; i < LENG; i++) isPalindrome[i][i] = true;

        // 길이가 2인 회문
        for (int i = 0; i < LENG - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                isPalindrome[i][i+1] = true;
                maxLen = 2;
            }
        }

        // 길이가 3 이상인 회문
        for (int len = 3; len <= LENG; len++) {
            for (int startIdx = 0; startIdx <= LENG - len; startIdx++) {
                int endIdx = startIdx + len - 1;
                if (
                        isPalindrome[startIdx + 1][endIdx - 1] &&
                                str.charAt(startIdx) == str.charAt(endIdx)
                ) {
                    isPalindrome[startIdx][endIdx] = true;
                    maxLen = len;
                }
            }
        }
        return maxLen;
    }
}
