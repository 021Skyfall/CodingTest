package baekjoon.경로;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1926 {
    static int[][] arr = new int[501][501];
    static boolean[][] chk = new boolean[501][501]; // 방문 여부

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int area = 0; // 그림의 넓이
        int max = 0;
        int num = 0; // 그림의 개수

        Queue<int[]> Q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chk[i][j] || arr[i][j] == 0) {
                    continue;
                }

                chk[i][j] = true;
                Q.add(new int[]{i, j});
                area = 0;
                num++;

                while (!Q.isEmpty()) {
                    int[] cur = Q.poll();
                    area++;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                            continue;
                        }

                        if (chk[nx][ny] || arr[nx][ny] == 0) {
                            continue;
                        }

                        chk[nx][ny] = true;
                        Q.add(new int[]{nx, ny});
                    }

                    if (max < area) {
                        max = area;
                    }
                }
            }
        }

        System.out.println(num);
        System.out.println(max);

        scanner.close();
    }
}
