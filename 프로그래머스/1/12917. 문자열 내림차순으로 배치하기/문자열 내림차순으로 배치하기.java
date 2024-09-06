import java.util.*;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        Character[] sArr = new Character[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sArr[i] = arr[i];
        }

        Arrays.sort(sArr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (char i : sArr) {
            sb.append(i);
        }

        return sb.toString();
    }
}