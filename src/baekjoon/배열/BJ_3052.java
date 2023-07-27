package baekjoon.배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_3052 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            int x = n % 42;
            arr[i] = x;
        }
        System.out.println(Arrays.stream(arr).distinct().count());
    }
}
