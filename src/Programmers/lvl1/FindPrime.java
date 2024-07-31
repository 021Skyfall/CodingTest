package Programmers.lvl1;

import java.util.Arrays;

public class FindPrime {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }
    public static int solution(int n) {
        // 에라토스테네스의 체
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean b : isPrime) {
            if (b) {
                count++;
            }
        }

        return count;
    }
}
