package baekjoon.반복;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2439 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 1; i <= n; i++) {
            System.out.println(" ".repeat(n-i)+"*".repeat(i));
        }
    }
}
