package baekjoon.정렬;

import java.io.*;
import java.util.*;

public class BJ_11497 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] logs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

            int[] reLogs = new int[n]; // 통나무 재배치
            int left = 0;
            int right = n - 1;

            // 통나무를 양 끝에서부터 번갈아 배열
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    reLogs[left++] = logs[i]; // 짝수 = 배열 왼쪽에 추가
                } else {
                    reLogs[right--] = logs[i]; // 홀수 = 배열 오른쪽에 추가
                }
            }

            // 재배치된 통나무들 간 높이 차이 계산
            int maxDiff = 0;
            for (int i = 0; i < n - 1; i++) {
                maxDiff = Math.max(maxDiff, Math.abs(reLogs[i] - reLogs[i + 1]));
            }
            // 첫 번째와 마지막 통나무 간 높이 차이 고려
            maxDiff = Math.max(maxDiff, Math.abs(reLogs[0] - reLogs[n - 1]));

            System.out.println(maxDiff);
        }
    }
}
