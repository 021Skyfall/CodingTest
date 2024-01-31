import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int x, y, n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken()) + 500;
        y = Integer.parseInt(st.nextToken()) + 500;
        n = Integer.parseInt(st.nextToken());

        arr = new int[1001][1001];
        visited = new boolean[1001][1001];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int poolX = Integer.parseInt(st.nextToken()) + 500;
            int poolY = Integer.parseInt(st.nextToken()) + 500;

            visited[poolX][poolY] = true;
        }

        bfs();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {500, 500, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int curX = cur[0] + dx[i];
                int curY = cur[1] + dy[i];

                if (Math.abs(curX) <= 1001 && Math.abs(curY) <= 1001 && !visited[curX][curY]) {
                    visited[curX][curY] = true;
                    if (curX == x && curY == y) {
                        System.out.println(cur[2] + 1);
                        return;
                    }
                    q.offer(new int[]{curX, curY, cur[2] + 1});
                }
            }
        }
    }
}