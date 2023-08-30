package baekjoon.일반수학1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2292 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int count = 1; // 최소 루트
        int range = 2; // 범위

        if (n == 1) {
            System.out.println(1);
        }

        else {
            while (range <= n) {
                range += (6 * count);
                count++;
            }

            System.out.println(count);
        }
    }
}
