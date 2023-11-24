import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int[][][] dst;
    static boolean[][][] visited;
    static int n,m;
    public static void main(String[] args) throws java.io.IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

       arr = new int[n][m];
       dst = new int[n][m][2];
       visited = new boolean[n][m][2];

       for (int i = 0; i < n; i++) {
           String r = br.readLine();
           for (int j = 0; j < m; j++) {
               arr[i][j] = Integer.parseInt(String.valueOf(r.charAt(j)));
           }
       }

       bfs();

       if (dst[n - 1][m - 1][0] == 0 && dst[n - 1][m - 1][1] == 0) {
           System.out.println(-1);
       } else if (dst[n - 1][m - 1][0] == 0) {
           System.out.println(dst[n - 1][m - 1][1]);
       } else if (dst[n - 1][m - 1][1] == 0) {
           System.out.println(dst[n - 1][m - 1][0]);
       } else {
           System.out.println(Math.min(dst[n - 1][m - 1][0],dst[n - 1][m - 1][1]));
       }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited[0][0][0] = true;
        dst[0][0][0] = 1;
        q.offer(new int[]{0,0,0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int wall = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (arr[nx][ny] == 0 && !visited[nx][ny][wall]) {
                        q.offer(new int[]{nx, ny, wall});
                        visited[nx][ny][wall] = true;
                        dst[nx][ny][wall] = dst[cur[0]][cur[1]][wall] + 1;
                    }
                    if (arr[nx][ny] == 1 && wall == 0 && !visited[nx][ny][wall + 1]) {
                        q.offer(new int[]{nx, ny, wall + 1});
                        visited[nx][ny][wall + 1] = true;
                        dst[nx][ny][wall + 1] = dst[cur[0]][cur[1]][wall] + 1;
                    }
                }
            }
        }
    }
}