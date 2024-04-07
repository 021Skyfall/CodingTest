package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 등수매기기 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] expected = new int[n];

        for (int i = 0; i < n; i++) {
            expected[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(expected);

        long dis = 0;
        for (int i = 0; i < n; i++) {
            // 실제 등수와 예상 등수 사이의 차이를 절대값으로 계산 후 추가
            dis += Math.abs(expected[i] - (i + 1));
        }

        System.out.println(dis);
    }
}
