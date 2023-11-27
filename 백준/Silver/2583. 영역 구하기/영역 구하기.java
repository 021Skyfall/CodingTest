import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] visited;
    static int m, n, count = 0;
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 그래프, 방문 여부 초기화
        arr = new int[m][n];
        visited = new boolean[m][n];

        // 그래프 - 직사각형 위치를 1로 표현
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = m - y2; i < m - y1; i++) {
                for (int j = x1; j < x2; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        // 탐색 - 0인 경우 이동 가능
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {

                    dfs(i, j);
//                    bfs(i, j);
                    list.add(count);
                    count = 0;
                }
            }
        }

        // 오름차순 정렬
        Collections.sort(list);
        System.out.println(list.size());

        StringBuilder sb = new StringBuilder();
        for (int v : list) {
            sb.append(v).append(" ");
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
    public static void bfs (int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[]{x,y});
        count++;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        count++;
                    }
                }
            }
        }
    }
}