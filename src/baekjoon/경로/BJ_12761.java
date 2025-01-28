package baekjoon.경로;

import java.util.*;

public class BJ_12761 {
    static int a, b, n, m;
    static int[] graph = new int[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        n = scanner.nextInt();
        m = scanner.nextInt();
        Arrays.fill(graph, -1); // 그래프 초기화

        solution(n);

        scanner.close();
    }

    public static void solution(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        graph[start] = 0;

        while (!q.isEmpty()) {
            int l = q.poll();
            for (int i : new int[]{l - 1, l + 1, l - a, l + a, l - b, l + b, l * a, l * b}) {
                if (0 <= i && i <= 100000 && graph[i] == -1) {
                    q.add(i);
                    graph[i] = graph[l] + 1;
                }
                if (i == m) {
                    System.out.println(graph[m]);
                    return;
                }
            }
        }
    }
}
