package baekjoon.수학;

import java.io.*;
import java.util.Scanner;

public class BJ_1850 {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        long b = scanner.nextLong();

        long answer = gcd(a, b);

        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < answer; i++) {
            sb.append("1");
        }
        System.out.print(sb);

        scanner.close();
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
