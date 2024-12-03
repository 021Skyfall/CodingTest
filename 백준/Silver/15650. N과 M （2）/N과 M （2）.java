import java.util.*;

public class Main {
    static int n, m;
    static List<Integer> s = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        dfs(1);
    }

    static void dfs(int start) {
        if (s.size() == m) {
            System.out.println(s.toString().replaceAll("[\\[\\],]", ""));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!s.contains(i)) {
                s.add(i);
                dfs(i + 1);
                s.remove(s.size() - 1);
            }
        }
    }
}