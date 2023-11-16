import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][][] arr;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();
    static int n, count = 0;

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        arr = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        q.offer(new int[]{i,j,k});
                    }
                }
            }
        }

        System.out.println(bfs(m, n, h));
    }

    public static int bfs(int m, int n, int h) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = cur[2] + dx[i];
                int ny = cur[1] + dy[i];
                int nz = cur[0] + dz[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < m && ny < n && nz < h) {
                    if (arr[nz][ny][nx] == 0) {
                        q.offer(new int[]{nz, ny, nx});
                        arr[nz][ny][nx] = arr[cur[0]][cur[1]][cur[2]] + 1;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 0) {
                        return -1;
                    }
                    max = Math.max(max, arr[i][j][k]);
                }
            }
        }

        if (max == 1) return 0;
        else return max - 1;
    }
}