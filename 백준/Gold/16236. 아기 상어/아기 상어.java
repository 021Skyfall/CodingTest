import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Point implements Comparable<Point> {
    int x, y, dist;

    public Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(Point other) {
        if (this.dist == other.dist) {
            if (this.x == other.x) {
                return Integer.compare(this.y, other.y);
            } else {
                return Integer.compare(this.x, other.x);
            }
        } else {
            return Integer.compare(this.dist, other.dist);
        }
    }
}

public class Main {
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    static int[][] arr;
    static int n, x, y, size = 2, count = 0, time = 0;
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    x = i;
                    y = j;
                    arr[i][j] = 0;
                }
            }
        }

        while (true) {
            Point p = bfs();
            if (p == null) break;
            time += p.dist;
            count++;
            if (count == size) {
                size++;
                count = 0;
            }
            arr[p.x][p.y] = 0;
            x = p.x;
            y = p.y;
        }

        System.out.println(time);
    }

    static Point bfs() {
        boolean[][] visited = new boolean[n][n];
        Queue<Point> q = new LinkedList<>();
        List<Point> fishes = new ArrayList<>();
        visited[x][y] = true;
        q.offer(new Point(x, y, 0));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= n || ny >= n || nx < 0 || ny < 0) {
                    continue;
                }
                if (visited[nx][ny] || arr[nx][ny] > size) {
                    continue;
                }
                visited[nx][ny] = true;
                q.offer(new Point(nx, ny, cur.dist + 1));
                if (arr[nx][ny] > 0 && arr[nx][ny] < size) {
                    fishes.add(new Point(nx, ny, cur.dist + 1));
                }
            }
        }
        return fishes.isEmpty() ? null : Collections.min(fishes);
    }
}