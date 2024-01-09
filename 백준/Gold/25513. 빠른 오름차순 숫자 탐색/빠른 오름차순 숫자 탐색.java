import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r, c;
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
        visited[r][c] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c, 0});

        int target = 1;
        int move = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (arr[cur[0]][cur[1]] == target) {
                if (target == 6) return move + cur[2];
                target++;
                move += cur[2];
                q.clear();
                visited = new boolean[5][5];
                visited[cur[0]][cur[1]] = true;
                q.offer(new int[]{cur[0], cur[1], 0});
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nx][ny] && arr[nx][ny] != -1) {
                    if (arr[nx][ny] == 0) visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }

        return -1;
    }
}