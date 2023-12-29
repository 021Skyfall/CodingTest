import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int a, k;
    static boolean[] visited;

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[k + 1];

        bfs();
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a, 0});
        visited[a] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int val = cur[0];
            int count = cur[1];

            if (val == k) {
                System.out.println(count);
                return;
            }

            if (val * 2 <= k) {
                visited[val * 2] = true;
                q.offer(new int[]{val * 2, count + 1});
            }

            if (!visited[val + 1]) {
                q.offer(new int[]{val + 1, count + 1});
            }
        }

        System.out.println(-1);
    }
}