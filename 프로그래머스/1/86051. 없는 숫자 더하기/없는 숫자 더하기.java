class Solution {
    public int solution(int[] numbers) {
        boolean[] exists = new boolean[10];
        int result = 0;

        for (int num : numbers) {
            if (num >= 0 && num <= 9) {
                exists[num] = true;
            }
        }

        for (int i = 0; i <= 9; i++) {
            if (!exists[i]) {
                result += i;
            }
        }

        return result;
    }
}