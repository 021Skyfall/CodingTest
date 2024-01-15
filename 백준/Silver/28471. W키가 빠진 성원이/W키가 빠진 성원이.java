import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, count = 0;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, -1, -1, 1, 1}; // 좌, 우, 하 + 좌상, 우상, 좌하, 우하
    static int[] dy = {0, 1, -1, -1, 1, -1, 1}; // 좌, 우, 하 + 좌상, 우상, 좌하, 우하

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new char[n][n];

        int fx = 0, fy = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'F') {
                    fx = i;
                    fy = j;
                }
            }
        }

        bfs(fx, fy);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j] && arr[i][j] == '.'){
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void bfs(int x, int y) {
        visited = new boolean[n][n];
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 7; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && arr[nx][ny] != '#') {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}