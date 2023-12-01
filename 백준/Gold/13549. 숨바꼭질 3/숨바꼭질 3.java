import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int max = 100001;

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[max];
        visited = new boolean[max];

        bfs(n, k);

        System.out.println(arr[k]);
    }

    public static void bfs(int start, int end) {
        visited[start] = true;
        arr[start] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == end) {
                break;
            }

            if (cur * 2 < max && !visited[cur * 2]) {
                q.offer(cur * 2);
                visited[cur * 2] = true;
                arr[cur * 2] = arr[cur];
            }
            if (cur - 1 >= 0 && !visited[cur - 1]) {
                q.offer(cur - 1);
                visited[cur - 1] = true;
                arr[cur - 1] = arr[cur] + 1;
            }
            if (cur + 1 < max && !visited[cur + 1]) {
                q.offer(cur + 1);
                visited[cur + 1] = true;
                arr[cur + 1] = arr[cur] + 1;
            }
        }
    }
}