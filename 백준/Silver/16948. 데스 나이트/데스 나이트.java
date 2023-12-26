import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] dir = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};
    static boolean[][] visited;
    static int[] start, end;

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        visited = new boolean[n][n];

        bfs();
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0}); // 시작 위치와 거리 포함
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curDist = cur[2];

            if (curX == end[0] && curY == end[1]) {
                System.out.println(curDist);
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    q.offer(new int[]{nextX, nextY, curDist + 1}); // 다음으로
                }
            }
        }

        System.out.println(-1);
    }
}