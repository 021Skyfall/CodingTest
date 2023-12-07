import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] color;

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 정점의 개수
            int e = Integer.parseInt(st.nextToken()); // 간선의 개수

            tree = new ArrayList[v + 1];
            color = new int[v + 1];

            for (int i = 0; i <= v; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                tree[x].add(y);
                tree[y].add(x);
            }

            boolean isBipartite = true;
            for(int i=1; i <= v; i++) {
                if(color[i] == 0) {
                    if(dfs(i, 1)) {
                        isBipartite = false;
                        break;
                    }
                }
            }
            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    static boolean dfs(int node, int c) {
        color[node] = c;

        for (int i : tree[node]) {
            if (color[i] == 0) {
                if (dfs(i, 3 - c)) return true;
            } else if (color[i] == color[node]) {
                return true;
            }
        }
        return false;
    }
}