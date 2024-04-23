package baekjoon.정렬;

import java.io.*;
import java.util.*;

public class BJ_17390 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1]; // 배열의 인덱스를 1부터 시작하기 위해 N+1 크기로 설정
        long[] prefixSum = new long[N+1]; // 누적 합 배열도 같은 이유로 N+1 크기로 설정

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 배열 정렬

        // 누적 합 계산
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            // L부터 R까지의 누적 합을 이용하여 구간 합 계산
            sb.append(prefixSum[R] - prefixSum[L-1]).append('\n');
        }

        System.out.println(sb);
    }
}
