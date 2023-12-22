import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] damage = new int[][]{
            {9, 3, 1}, {9, 1, 3},
            {3, 9, 1}, {3, 1, 9},
            {1, 3, 9}, {1, 9, 3}
    };
    static boolean[][][] visited;
    static int[] scv;
    static int n;
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        scv = new int[3];
        visited = new boolean[61][61][61];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{scv[0], scv[1], scv[2], 0}); // scv 체력 + 공격 횟수
        visited[scv[0]][scv[1]][scv[2]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == 0 && cur[1] == 0 && cur[2] == 0) {
                return cur[3]; // 모든 scv가 파괴되었다면 현재 공격 횟수 반환
            }

            // 가능한 모든 공격 조합
            for (int[] attack : damage) {
                int a = Math.max(0, cur[0] - attack[0]);
                int b = Math.max(0, cur[1] - attack[1]);
                int c = Math.max(0, cur[2] - attack[2]);

                if (!visited[a][b][c]) {
                    visited[a][b][c] = true;
                    q.offer(new int[]{a, b, c, cur[3] + 1});
                }
            }
        }

        // 더미
        return -1;
    }
}