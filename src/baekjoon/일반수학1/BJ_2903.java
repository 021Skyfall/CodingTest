package baekjoon.일반수학1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2903 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println((int) Math.pow(Math.pow(2, n) + 1, 2));
    }
}
