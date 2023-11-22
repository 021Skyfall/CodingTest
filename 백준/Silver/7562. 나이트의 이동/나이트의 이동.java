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
    static Node start, end;
    static int l;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


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
                    start = new Node(x, y);
                } else {
                    end = new Node(x, y);
                }
            }

            if (start.x == end.x && start.y == end.y) {
                System.out.println(0);
                continue;
            }

            bfs();
        }
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();
            if (node.x == end.x && node.y == end.y) {
                System.out.println(arr[end.x][end.y]);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < l && ny < l) {
                    if (!visited[nx][ny]) {
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                        arr[nx][ny] = arr[node.x][node.y] + 1;
                    }
                }
            }
        }
    }
}