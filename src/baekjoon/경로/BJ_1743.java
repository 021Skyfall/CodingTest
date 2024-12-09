package baekjoon.경로;

import java.util.Scanner;

public class BJ_1743 {
    static int N, M, k;
    static int[][] graph;
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int cnt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        k = scanner.nextInt();

        graph = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < k; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            graph[n - 1][m - 1] = 1; // 1로 초기화
        }

        int big = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (graph[x][y] == 1 && visited[x][y] == 0) { // 1이면서 방문하지 않은 경우
                    cnt = 1; // 카운트 초기화
                    DFS(graph, visited, x, y);
                    big = Math.max(cnt, big); // 최대 개수 갱신
                }
            }
        }

        System.out.println(big);
        scanner.close();
    }

    static void DFS(int[][] graph, int[][] visited, int x, int y) {
        visited[x][y] = cnt; // 현재 위치 방문 처리

        for (int i = 0; i < 4; i++) { // 4방향 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == 0 && graph[nx][ny] == 1) {
                cnt++; // 카운트 증가
                DFS(graph, visited, nx, ny); // 재귀 호출
            }
        }
    }
}
