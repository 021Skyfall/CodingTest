import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() != 1) {
            System.out.print(q.peek() + " ");
            q.poll();
            q.add(q.peek());
            q.poll();
        }

        System.out.println(q.peek());
        scanner.close();
    }
}