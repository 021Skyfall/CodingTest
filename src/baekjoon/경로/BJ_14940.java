package baekjoon.경로;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_14940 {
    static int[][] board = new int[1002][1002];
    static int[][] dist = new int[1002][1002];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scanner.nextInt();
                if (board[i][j] == 2) {
                    q.add(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (dist[nx][ny] != -1) continue;
                if (board[nx][ny] == 0) continue;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.add(new int[]{nx, ny});
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
