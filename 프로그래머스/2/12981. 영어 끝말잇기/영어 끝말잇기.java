import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> used = new HashSet<>();
        int[] result = new int[2];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != word.charAt(0)) {
                result[0] = (i % n) + 1;
                result[1] = (i / n) + 1;
                return result;
            }

            if (used.contains(word)) {
                result[0] = (i % n) + 1;
                result[1] = (i / n) + 1;
                return result;
            }

            used.add(word);
        }

        result[0] = 0;
        result[1] = 0;
        return result;
    }
}