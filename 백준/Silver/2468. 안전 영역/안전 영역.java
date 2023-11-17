import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, max = 0;

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        int safeArea = 0;
        for (int i = 0; i <= max; i++) {
            visited = new boolean[n][n];
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] > i && !visited[j][k]) {
                        count++;
                        dfs(i,j,k);
                        // bfs(i,j,k);
                    }
                }
            }
            safeArea = Math.max(safeArea, count);
        }

        System.out.println(safeArea);
    }

    public static void dfs(int i, int x, int y) {
        visited[x][y] = true;

        for (int l = 0; l < 4; l++) {
            int nx = x + dx[l];
            int ny = y + dy[l];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (arr[nx][ny] > i && !visited[nx][ny]) {
                    dfs(i, nx, ny);
                }
            }
        }
    }

    public static void bfs(int i, int x, int y) {
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int l = 0; l < 4; l++) {
                int nx = cur[0] + dx[l];
                int ny = cur[1] + dy[l];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (arr[nx][ny] > i && !visited[nx][ny]) {
                        q.offer(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}