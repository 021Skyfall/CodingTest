import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static boolean[][] visited;
    static int[][] arr;
    static int[] start, end;
    static int l;


    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (n-- > 0) {
            l = Integer.parseInt(br.readLine());
            arr = new int[l][l];
            visited = new boolean[l][l];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    start = new int[]{x, y};
                } else {
                    end = new int[]{x, y};
                }
            }

            if (start[0] == end[0] && start[1] == end[1]) {
                System.out.println(0);
                continue;
            }

            bfs();
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) {
                System.out.println(arr[end[0]][end[1]]);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < l && ny < l) {
                    if (!visited[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        arr[nx][ny] = arr[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }
    }
}