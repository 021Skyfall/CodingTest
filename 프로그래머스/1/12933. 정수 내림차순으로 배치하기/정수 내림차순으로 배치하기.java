import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        Character[] arr = new Character[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        Arrays.sort(arr, Collections.reverseOrder());

        StringBuilder resultToStr = new StringBuilder();
        for (Character nums : arr) {
            resultToStr.append(nums);
        }

        return Long.parseLong(resultToStr.toString());
    }
}