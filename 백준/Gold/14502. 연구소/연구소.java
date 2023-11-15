import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr, copy;
    static int n, m;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(wall(0));
    }

    public static int wall(int count) {
        int maxArea = 0;
        if (count == 3) {
            for (int i = 0; i < n; i++) {
                System.arraycopy(arr[i], 0, copy[i], 0, m);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copy[i][j] == 2) {
                        virusDFS(i, j);
//                        virusBFS(i, j);
                    }
                }
            }
            return countSafeZone();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    maxArea = Math.max(maxArea, wall(count + 1));
                    arr[i][j] = 0;
                }
            }
        }
        return maxArea;
    }

    public static void virusDFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    virusDFS(nx, ny);
                }
            }
        }
    }

    public static void virusBFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (copy[nx][ny] == 0) {
                        copy[nx][ny] = 2;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static int countSafeZone() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}