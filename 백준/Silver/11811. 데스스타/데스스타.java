import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int m = scanner.nextInt();
                if (i == j) continue;
                a[i] |= m;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        scanner.close();
    }
}