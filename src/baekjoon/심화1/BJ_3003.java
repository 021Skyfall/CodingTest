package baekjoon.심화1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_3003 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[]{1,1,2,2,2,8};

        for (int i = 0; i < arr.length; i++) {
            result[i] -= arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
               sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
