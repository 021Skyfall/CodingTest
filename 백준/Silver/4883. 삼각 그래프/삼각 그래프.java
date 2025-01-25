import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] graph = new int[100010][3];
        int[][] d = new int[100010][3];
        int t = 1;

        while (true) {
            int n = scanner.nextInt();
            if (n == 0) break;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    graph[i][j] = scanner.nextInt();
                }
            }

            d[0][0] = Integer.MAX_VALUE;
            d[0][1] = graph[0][1];
            d[0][2] = graph[0][1] + graph[0][2];

            for (int i = 1; i < n; i++) {
                d[i][0] = Math.min(d[i - 1][0], d[i - 1][1]) + graph[i][0];
                d[i][1] = Math.min(Math.min(d[i - 1][0], d[i - 1][1]), Math.min(d[i - 1][2], d[i][0])) + graph[i][1];
                d[i][2] = Math.min(Math.min(d[i - 1][1], d[i - 1][2]), d[i][1]) + graph[i][2];
            }

            System.out.println(t++ + ". " + d[n - 1][1]);
        }

        scanner.close();
    }
}