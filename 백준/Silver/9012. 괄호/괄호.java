import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '(') {
                    stack.push(ch);
                } else if (!stack.isEmpty() && ch == ')') {
                    stack.pop();
                } else {
                    stack.push(ch);
                    break;
                }
            }

                if (stack.isEmpty())
                    sb.append("YES").append('\n');
                else
                    sb.append("NO").append('\n');

                stack.clear();
            }

            System.out.println(sb);
    }
}