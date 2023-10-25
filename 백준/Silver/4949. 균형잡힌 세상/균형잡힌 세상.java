import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String str;

        while ((str = br.readLine()) != null) {
            if (str.equals("."))
                break;
            boolean isBalanced = true;

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        isBalanced = false;
                        break;
                    }
                } else if (ch == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        isBalanced = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty() || !isBalanced)
                sb.append("no").append('\n');
            else
                sb.append("yes").append('\n');

            stack.clear();
        }

        System.out.println(sb);
    }
}