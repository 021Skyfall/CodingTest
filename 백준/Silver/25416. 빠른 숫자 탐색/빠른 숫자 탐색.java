import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r, c, count = 0;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[5][5];
        visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c, 0});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int dist = cur[2];


            if (arr[cur[0]][cur[1]] == 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                    if ((arr[nx][ny] == 0 || arr[nx][ny] == 1) && !visited[nx][ny]) {
                        q.offer(new int[]{nx, ny, dist + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return -1;
    }
}