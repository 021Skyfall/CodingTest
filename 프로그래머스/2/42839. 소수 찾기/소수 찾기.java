import java.util.*;

class Solution {
    private Set<Integer> primes = new HashSet<>();

    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        generatePermutations(numbers, "", visited);

        int count = 0;
        for (int num : primes) {
            if (isPrime(num)) {
                count++;
            }
        }
        return count;
    }

    private void generatePermutations(String numbers, String current, boolean[] visited) {
        if (!current.isEmpty()) {
            primes.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                generatePermutations(numbers, current + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}