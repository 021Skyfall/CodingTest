class Solution {
    public int solution(int[] a, int[] b) {
        int dot = 0;

        for (int i = 0; i < a.length; i++) {
            dot += a[i] * b[i];
        }

        return dot;
    }
}