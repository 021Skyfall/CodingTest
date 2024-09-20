package baekjoon.경로;

import java.io.*;
import java.util.StringTokenizer;

public class ChangYoungBus_22113 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정류장 수
        int m = Integer.parseInt(st.nextToken()); // 버스 노선 수
        int[] arr = new int[m]; // 노선 정류장 저장

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 각 노선 정류장 입력
        }

        int[][] map = new int[n + 1][n + 1]; // 요금 맵
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 요금 입력
            }
        }

        int totalFare = 0; // 총 요금
        for (int i = 1; i < m; i++) {
            totalFare += map[arr[i - 1]][arr[i]]; // 요금 합산
        }

        System.out.println(totalFare);
    }
}
