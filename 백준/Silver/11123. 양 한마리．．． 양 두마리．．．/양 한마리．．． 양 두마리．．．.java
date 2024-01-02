import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int h, w;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            arr = new char[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                String x = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = x.charAt(j);
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == '#' && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        int count = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                    if (arr[nx][ny] == '#' && !visited[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}