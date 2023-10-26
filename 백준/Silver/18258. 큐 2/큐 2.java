import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "push" :
                    q.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    sb.append(q.isEmpty() ? -1 : q.poll()).append('\n');
                    break;
                case "size" :
                    sb.append(q.size()).append('\n');
                    break;
                case "empty" :
                    sb.append(q.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front" :
                    sb.append(q.isEmpty() ? -1 : q.peek()).append('\n');
                    break;
                case "back" :
                    sb.append(q.isEmpty() ? -1 : ((LinkedList<Integer>) q).peekLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}