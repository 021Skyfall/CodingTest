import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int start = 0, end = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (end < n) {
            sum += sequence[end];

            while (sum > k && start <= end) {
                sum -= sequence[start];
                start++;
            }

            if (sum == k && (end - start + 1) < minLength) {
                minLength = end - start + 1;
                result[0] = start;
                result[1] = end;
            }

            end++;
        }

        return result;
    }
}