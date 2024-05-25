import java.util.*;

class Solution {
    public int solution(int []A, int []B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int result = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            result += A[i] * B[length - 1 - i];
        }

        return result;
    }
}