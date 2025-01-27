package baekjoon.수학;

import java.util.Scanner;

public class BJ_1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;

        for (int i = n; i <= 1000000; i++) {
            if (i == 1) continue;

            // 팰린드롬 확인
            String numStr = Integer.toString(i);
            String reversed = new StringBuilder(numStr).reverse().toString();

            if (numStr.equals(reversed) && isPrime(i)) {
                result = i;
                break;
            }
        }

        if (result == 0) {
            result = 1003001;
        }

        System.out.println(result);
    }

    // 소수 판별 함수
    private static boolean isPrime(int x) {
        if (x == 1) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
