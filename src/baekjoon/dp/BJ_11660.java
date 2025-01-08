package baekjoon.dp;

import java.util.Scanner;

public class BJ_11660 {
    static int[][] map = new int[1206][1206]; // i,j까지 합

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int temp;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                temp = scanner.nextInt();
                map[i][j] = map[i - 1][j] + map[i][j - 1] + temp - map[i - 1][j - 1];
                // i,j 까지 합 구하기
            }
        }

        for (int i = 0; i < m; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int result = map[x2][y2] - map[x1 - 1][y2] - map[x2][y1 - 1] + map[x1 - 1][y1 - 1];
            // 사이 구간 합
            System.out.println(result);
        }

        scanner.close();
    }
}
