import java.util.*;

public class Main {
    static int answer = 0;

    public static void recur(List<Integer> v, int sum) {
        if (v.size() == 2) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 1; i < v.size() - 1; ++i) {
            int energy = v.get(i - 1) * v.get(i + 1);

            // 새로운 리스트 복사
            List<Integer> copy = new ArrayList<>(v);
            copy.remove(i);

            recur(copy, sum + energy);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        List<Integer> v = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            v.add(scanner.nextInt());
        }

        recur(v, 0);

        System.out.println(answer);
        scanner.close();
    }
}