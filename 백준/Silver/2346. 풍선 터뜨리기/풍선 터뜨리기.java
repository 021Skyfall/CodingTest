import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<int[]> q = new ArrayDeque<>();
        int[] arr =  new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < n; i++) {
            q.add(new int[]{(i+1), arr[i]});
        }

        StringBuilder sb = new StringBuilder();
        sb.append(1).append(' ');
        int index = arr[0];
        while (!q.isEmpty()) {
            if (index > 0) {
                for (int i = 1; i < index; i++) {
                    q.offer(q.poll());
                }
                int[] next = q.poll();
                index = next[1];
                sb.append(next[0]).append(' ');
            } else {
                for (int i = 1; i < -index; i++) {
                    q.offerFirst(q.pollLast());
                }
                int[] next = q.pollLast();
                index = next[1];
                sb.append(next[0]).append(' ');
            }
        }

        System.out.println(sb);
    }
}