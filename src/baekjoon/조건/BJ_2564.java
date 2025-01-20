package baekjoon.조건;

import java.util.Scanner;

public class BJ_2564 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int n = scanner.nextInt();
        int[] store = new int[n];
        int p, x, sum = 0;

        for (int i = 0; i < n; i++) {
            p = scanner.nextInt();
            x = scanner.nextInt();
            store[i] = solution(p, x, w, h);
        }

        p = scanner.nextInt();
        x = scanner.nextInt();
        x = solution(p, x, w, h);
        w = 2 * (w + h);

        for (int i = 0; i < n; i++) {
            p = (store[i] - x + w) % w;
            if (p * 2 > w) p = w - p;
            sum += p;
        }

        System.out.println(sum);
        scanner.close();
    }

    public static int solution(int p, int x, int w, int h) {
        if (p == 1) return h + x;
        if (p == 2) return 2 * (w + h) - x;
        if (p == 3) return h - x;
        return w + h + x;
    }
}
