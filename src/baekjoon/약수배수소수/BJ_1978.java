package baekjoon.약수배수소수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1978 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int count = 0;
        br.close();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(arr[i]);
            if (x == 1) continue;
            if (isPrime(x)) count++;
        }

        System.out.println(count);
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i*i <= num; i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }
}