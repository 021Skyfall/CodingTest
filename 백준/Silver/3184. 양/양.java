import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r, c, allK = 0, allV = 0;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String x = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = x.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if ((arr[i][j] == '.' || arr[i][j] == 'v' || arr[i][j] == 'o')  && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(allK + " " + allV);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});

        int k = 0, v = 0;
        if (arr[x][y] == 'o') k++;
        if (arr[x][y] == 'v') v++;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c && !visited[nx][ny] && arr[nx][ny] != '#') {
                    visited[nx][ny] = true;
                    if (arr[nx][ny] == 'o') k++;
                    if (arr[nx][ny] == 'v') v++;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        if (k > v) {
            allK += k;
        } else {
            allV += v;
        }
    }
}