package baekjoon.배열2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int total = 0; // 색종이 영역
        int n = Integer.parseInt(br.readLine()); // 색종이 개수
        boolean[][] arr = new boolean[100][100]; // 도화지 크기

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // x 좌표 + 10 , y 좌표 + 10 = 색종이 크기
            for (int j = x; j < x+10; j++) {
                for (int k = y; k < y+10; k++) {
                    // 겹치지는 부분 엣지케이스
                    if (!arr[j][k]) {
                        arr[j][k] = true;
                        // 겹치지 않는 부분만 +
                        total++;
                    }
                }
            }
        }

        System.out.println(total);
    }
}
