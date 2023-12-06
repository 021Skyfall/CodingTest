import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static long a;
    static long b;
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{a, 1});

        while (!q.isEmpty()) {
            Object[] cur = q.poll();
            long value = (long) cur[0];
            int count = (int) cur[1];

            if (value == b) {
                System.out.println(count);
                return;
            }

            if (value * 2 <= b) {
                q.add(new Object[]{value * 2, count + 1});
            }

            if (value * 10 + 1 <= b) {
                q.add(new Object[]{value * 10 + 1, count + 1});
            }
        }

        System.out.println(-1);
    }
}