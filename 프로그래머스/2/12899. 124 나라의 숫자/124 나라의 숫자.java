class Solution {
    public String solution(int n) {
        String[] num = {"4", "1", "2"};
        StringBuilder answer = new StringBuilder();

        while (n > 0) {
            int remainder = n % 3;
            n = n / 3;

            if (remainder == 0) {
                n -= 1;
            }

            answer.insert(0, num[remainder]);
        }

        return answer.toString();
    }
}