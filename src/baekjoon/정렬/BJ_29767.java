package baekjoon.정렬;

import java.io.*;
import java.util.*;

public class BJ_29767 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n과 k를 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 데이터를 입력받아 배열에 저장
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp 배열 초기화 및 구성
        long[] dp = new long[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        // dp 배열을 내림차순으로 정렬
        Arrays.sort(dp);

        // k번째까지의 합을 계산하기 위해 배열의 뒤에서부터 k개 요소의 합을 계산
        long sum = 0;
        for (int i = n - 1; i >= n - k; i--) {
            sum += dp[i];
        }

        // 결과 출력
        System.out.println(sum);
    }
}
