class Solution {
    public int solution(int n) {
        // 3진법
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int rem = n % 3;
            sb.insert(0, rem);
            n /= 3;
        }

        sb.reverse();

        // 10 진법
        int result = 0;
        for (int i = 0; i < sb.length(); i++) {
            int digit = Character.getNumericValue(sb.charAt(sb.length() - 1 - i));
            result += (int) (digit * Math.pow(3, i));
        }

        return result;
    }
}