import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] change;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        change = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j) - '0';
                change[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.offer(new int[]{0, 0, 0});
        change[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], cnt = cur[2];

            if (x == n - 1 && y == n - 1) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    int nextCnt = cnt + (arr[nx][ny] == 0 ? 1 : 0);  // 검은 방을 만나면 cnt를 1 증가
                    if (change[nx][ny] > nextCnt) {
                        change[nx][ny] = nextCnt;
                        pq.offer(new int[]{nx, ny, nextCnt});
                    }
                }
            }
        }

        return 0;
    }
}