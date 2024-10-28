import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] arr = new int[N][3];

            int sum = 0;

            for (int j = 0; j < N; j++) {
                int dm = 0;
                for (int k = 0; k < 3; k++) {
                    arr[j][k] = scanner.nextInt();
                    if (arr[j][k] > dm) {
                        dm = arr[j][k];
                    }
                }
                sum += dm;
            }
            System.out.println(sum);
        }

        scanner.close();
    }
}