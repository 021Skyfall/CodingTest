package baekjoon.배열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_5597 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[30];
        System.out.println(Arrays.toString(arr));

        for (int i = 1; i < 29; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[x] = 1;
        }
        br.close();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 1)
                System.out.println(i);
        }
    }
}
