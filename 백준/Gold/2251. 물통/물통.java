import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited = new boolean[201][201]; // A와 B 물통의 상태를 체크
    static boolean[] answer = new boolean[201]; // 가능한 C 물통의 물의 양을 저장
    static int[] from = {0, 0, 1, 1, 2, 2}; // 물을 옮겨 내는 물통
    static int[] to = {1, 2, 0, 2, 0, 1}; // 물을 받는 물통
    static int[] limit;

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        limit = new int[3];
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        bfs();

        // 가능한 c 물통의 물의 양 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 200; i++) {
            if (answer[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, limit[2]});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0], b = cur[1], c = cur[2];
            if (visited[a][b]) continue; // 이미 방문
            visited[a][b] = true; // 방문 체크
            if (a == 0) answer[c] = true; // A가 비었을 때 C의 상태 저장

            for (int i = 0; i < 6; i++) { // 물을 옮길 수 있는 모든 경우의 수
                int[] next = cur.clone();
                next[to[i]] += next[from[i]];
                next[from[i]] = 0;

                if (next[to[i]] > limit[to[i]]) {
                    next[from[i]] = next[to[i]] - limit[to[i]];
                    next[to[i]] = limit[to[i]];
                }

                q.offer(next); // 다음 상태 추가
            }
        }
    }
}