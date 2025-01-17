import java.util.*;

public class Main {
    static int n, w, l, result;
    static int[] a;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        w = scanner.nextInt();
        l = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        scanner.close();

        int sum = 0; // 다리 위의 트럭 무게의 합
        for (int i = 0; i < n; i++) {
            while (true) {
                if (q.size() == w) {
                    sum -= q.poll(); // 맨 앞의 트럭 제거
                }
                if (a[i] + sum <= l) {
                    break;
                }
                q.add(0); // 무게가 L을 넘는 경우
                result++;
            }
            q.add(a[i]);
            sum += a[i];
            result++;
        }

        System.out.println(result + w); // 마지막 트럭이 건너는 시간(W) 추가
    }
}