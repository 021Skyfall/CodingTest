package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 보물 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        Integer[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().boxed().toArray(Integer[]::new);

        Arrays.sort(B, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += A[i] * B[i];
        }

        System.out.println(result);
    }
}
