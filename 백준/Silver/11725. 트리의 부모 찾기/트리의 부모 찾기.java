import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        parent = new int[n + 1];
        visited = new boolean[n + 1];

//        dfs(1, 0);
        bfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int node, int x) {
        visited[node] = true;
        parent[node] = x;

        for (int child : tree[node]) {
            if (!visited[child]) {
                dfs(child, node);
            }
        }
    }

    public static void bfs(int node) {
        visited[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int child : tree[cur]) {
                if (!visited[child]) {
                    q.offer(child);
                    visited[child] = true;
                    parent[child] = cur;
                }
            }
        }
    }
}