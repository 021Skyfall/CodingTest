import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;

        while (N-- > 0) {
            String temp = scanner.next();
            Stack<Character> s = new Stack<>();
            s.push(temp.charAt(0));

            for (int i = 1; i < temp.length(); i++) {
                if (!s.isEmpty() && s.peek() == temp.charAt(i)) {
                    s.pop();
                } else {
                    s.push(temp.charAt(i));
                }
            }

            if (s.isEmpty()) count++;
        }
        System.out.println(count);
        scanner.close();
    }
}
