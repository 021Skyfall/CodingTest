package baekjoon.경로;

import java.util.*;

public class FindHer {
    static int t, m;
    static double[] res = new double[4];
    static List<Pair>[] adj = new List[4];

    static class Pair {
        int vertex;
        double probability;

        Pair(int vertex, double probability) {
            this.vertex = vertex;
            this.probability = probability;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 0; i < 4; i++) {
            adj[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            char s = scanner.next().charAt(0);
            char e = scanner.next().charAt(0);
            double p = scanner.nextDouble();
            adj[s - 'A'].add(new Pair(e - 'A', p));
        }

        for (int i = 0; i < 4; i++) {
            dfs(i, 0.25, 0);
        }

        System.out.printf("%.3f\n", res[0]);
        System.out.printf("%.3f\n", res[1]);
        System.out.printf("%.3f\n", res[2]);
        System.out.printf("%.3f\n", res[3]);
    }

    static void dfs(int now, double p, int cnt) {
        if (cnt == t) {
            res[now] += p * 100;
            return;
        }

        for (Pair i : adj[now]) {
            dfs(i.vertex, p * i.probability, cnt + 1);
        }
    }
}
