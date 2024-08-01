class Solution {
    public static int solution(int[] nums) {
        int count = 0;

        // 3개의 수를 선택하기 위한 중첩 루프
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    // 소수인지 확인
                    if (isPrime(sum)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
    
        // 소수 판별 함수
    private static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}