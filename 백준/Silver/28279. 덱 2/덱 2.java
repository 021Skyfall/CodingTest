import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Deque<Integer> deck = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "1" :
                    deck.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "2" :
                    deck.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "3" :
                    sb.append(deck.isEmpty() ? -1 : deck.pollFirst()).append('\n');
                    break;
                case "4" :
                    sb.append(deck.isEmpty() ? -1 : deck.pollLast()).append('\n');
                    break;
                case "5" :
                    sb.append(deck.size()).append('\n');
                    break;
                case "6" :
                    sb.append(deck.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "7" :
                    sb.append(deck.isEmpty() ? -1 : deck.peekFirst()).append('\n');
                    break;
                case "8" :
                    sb.append(deck.isEmpty() ? -1 : deck.peekLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}