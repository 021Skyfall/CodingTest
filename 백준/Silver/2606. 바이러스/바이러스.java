import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int com = Integer.parseInt(br.readLine());
        int root = Integer.parseInt(br.readLine());

        int[][] net = new int[com+1][com+1];

        for (int i = 0; i < root; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            net[x][y] = net[y][x] = 1;
        }

        System.out.println(bfs(net, com));
    }
    public static int bfs(int[][] net, int com) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[com+1];
        int start = 1;
        visited[start] = true;
        q.offer(start);

        int count = 0;

        while (!q.isEmpty()) {
            start = q.poll();

            for (int i = 1; i <= com; i++) {
                if (net[start][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;

                    count++;
                }
            }
        }

        return count;
    }
}