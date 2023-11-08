import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < arr.length; i++) {
            String root = br.readLine();
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(root.charAt(j)));
            }
        }
        System.out.println(bfs(arr, visited));
    }
    public static int bfs(int[][] arr, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                    if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                        q.offer(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        arr[nx][ny] = arr[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }
        return arr[arr.length - 1][arr[0].length - 1];
    }
}