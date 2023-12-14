import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  // 상, 하, 좌, 우
    static boolean[][] visited;

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(st.nextToken());
                arr[i][j] = x;
            }
        }

        int time = 0;
        while (true) {
            bfs(); // 외부 공기 찾음
            if (!melt()) { // 녹일 치즈 없으면 종료
                break;
            }
            time++;
            visited = new boolean[n][m]; // 방문 초기화
        }

        System.out.println(time);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && arr[nx][ny] != 1) {
                    visited[nx][ny] = true;
                    arr[nx][ny] = -1; // 외부 공기
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    // 외부 공기와 접촉한 치즈 삭제
    public static boolean melt() {
        boolean melted = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) { // 치즈인 경우
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dir[k][0];
                        int ny = j + dir[k][1];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == -1) { // 외부 공기와 접촉한 경우
                            count++;
                        }
                    }
                    if (count >= 2) { // 외부 공기와 2면 이상 접촉한 경우
                        arr[i][j] = 0; // 치즈 녹음
                        melted = true;
                    }
                }
            }
        }
        return melted;
    }
}