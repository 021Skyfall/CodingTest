import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> sumSet = new HashSet<>();
        int n = elements.length;

        int[] extendedElements = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            extendedElements[i] = elements[i % n];
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += extendedElements[i + j];
                sumSet.add(sum);
            }
        }

        return sumSet.size();
    }
}