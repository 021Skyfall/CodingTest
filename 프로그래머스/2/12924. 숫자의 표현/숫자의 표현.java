class Solution {
    public int solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) { // 각 숫자를 기준으로
                sum += j;
                if (sum == n) {
                    count++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }

        return count;
    }
}