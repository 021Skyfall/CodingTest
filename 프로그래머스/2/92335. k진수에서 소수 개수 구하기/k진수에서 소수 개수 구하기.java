class Solution {
    public int solution(int n, int k) {
        String knum = Integer.toString(n, k);
        
        String[] parts = knum.split("0+");

        int primeCount = 0;
        
        for (String part : parts) {
            if (isPrime(part)) {
                primeCount++;
            }
        }
        
        return primeCount;
    }
    
    private boolean isPrime(String numStr) {
        if (numStr.isEmpty()) {
            return false;
        }
        
        long num = Long.parseLong(numStr);
        
        if (num < 2) {
            return false;
        }
        
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}