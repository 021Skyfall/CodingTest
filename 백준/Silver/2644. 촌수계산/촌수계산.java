import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, start,end;
    static int[] arr;
    static boolean[] visited;
    static int[] dist;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        bfs(start);

        if (dist[end] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dist[end]);
        }
    }

    static void bfs(int start) {
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == end) {
                return;
            }

            for (int child : tree[cur]) {
                if (!visited[child]) {
                    q.offer(child);
                    visited[child] = true;
                    dist[child] = dist[cur] + 1;
                }
            }
        }
    }
}