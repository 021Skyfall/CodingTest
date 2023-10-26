import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int start = 1;

        while (n-- > 0) {
            int x = Integer.parseInt(st.nextToken());

            stack.push(x);

            while (!stack.isEmpty() && stack.peek() == start) {
                stack.pop();
                start++;
            }
        }

        if (stack.isEmpty())
            System.out.println("Nice");
        else System.out.println("Sad");
    }
}