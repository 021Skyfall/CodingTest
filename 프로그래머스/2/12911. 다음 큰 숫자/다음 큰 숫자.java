class Solution {
    public static int solution(int n) {
        int nOnes = countOnes(n);
        int nextN = n + 1;

        while (countOnes(nextN) != nOnes) {
            nextN++;
        }

        return nextN;
    }
    private static int countOnes(int number) {
        int count = 0;
        while (number > 0) {
            count += number & 1;
            number >>= 1;
        }
        return count;
    }
}