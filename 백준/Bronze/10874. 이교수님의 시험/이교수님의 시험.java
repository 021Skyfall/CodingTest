import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            boolean c = true;
            int[] a = new int[11]; // 1 ~ 10

            for (int j = 1; j <= 10; j++) {
                a[j] = sc.nextInt();
                if (a[j] != (j - 1) % 5 + 1) {
                    c = false;
                }
            }

            if (c) {
                System.out.println(i);
            }
        }

        sc.close();
    }
}