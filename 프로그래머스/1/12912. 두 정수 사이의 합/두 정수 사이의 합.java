class Solution {
    public long solution(int a, int b) {
        long result = 0;

        if (a == b) {
            return a;
        } else if (a > b) {
            for (int i = b; i <= a; i++){
                result += i;
            }

            return result;
        } else {
            for (int i = a; i <= b; i++) {
                 result += i;
            }

            return result;
        }
    }
}