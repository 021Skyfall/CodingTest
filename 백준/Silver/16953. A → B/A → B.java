import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        Queue<long[]> q = new LinkedList<>();
        q.add(new long[]{a, 1});

        while (!q.isEmpty()) {
            long[] cur = q.poll();
            long value = cur[0];
            long count = cur[1];

            if (value == b) {
                System.out.println(count);
                return;
            }

            if (value * 2 <= b) {
                q.add(new long[]{value * 2, count + 1});
            }

            if (value * 10 + 1 <= b) {
                q.add(new long[]{value * 10 + 1, count + 1});
            }
        }

        System.out.println(-1);
    }
}