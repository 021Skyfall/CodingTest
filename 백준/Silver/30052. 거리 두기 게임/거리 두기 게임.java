import java.util.Scanner;

public class Main {
    public static int abs(int a) {
        return (a < 0) ? -a : a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 행의 수
        int m = scanner.nextInt(); // 열의 수
        int d = scanner.nextInt(); // 거리 D

        int[][] arr = new int[n + 1][m + 1];
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 왼쪽 위 모서리
                if (abs(1 - i) + abs(1 - j) < d) {
                    arr[i][j] = 1;
                }
                // 오른쪽 위 모서리
                if (arr[i][j] == 1 && abs(n - i) + abs(1 - j) < d) {
                    arr[i][j] = 2;
                }
                // 왼쪽 아래 모서리
                if (arr[i][j] == 2 && abs(1 - i) + abs(m - j) < d) {
                    arr[i][j] = 3;
                }
                // 오른쪽 아래 모서리
                if (arr[i][j] == 3 && abs(n - i) + abs(m - j) < d) {
                    sum++;
                }
            }
        }

        System.out.println(sum);
        scanner.close();
    }
}