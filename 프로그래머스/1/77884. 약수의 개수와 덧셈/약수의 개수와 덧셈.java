class Solution {
    public int solution(int left, int right) {
        int sum = 0;

        for (int i = left; i <= right; i++) {
            int divisorCount = countDivisors(i);

            if (divisorCount % 2 == 0) {
                sum += i;
            } else {
                sum -= i;
            }
        }

        return sum;
    }

    // 약수 개수를 계산
    private static int countDivisors(int num) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                count++;
                if (i != num / i) {
                    count++;
                }
            }
        }
        return count;
    }
}