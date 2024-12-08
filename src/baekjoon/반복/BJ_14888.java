package baekjoon.반복;

import java.util.Scanner;

public class BJ_14888 {
    static int n;
    static int[] number;
    static int add, sub, mul, div;
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = scanner.nextInt();
        }
        add = scanner.nextInt();
        sub = scanner.nextInt();
        mul = scanner.nextInt();
        div = scanner.nextInt();

        dfs(add, sub, mul, div, number[0], 1);

        System.out.println(maxResult);
        System.out.println(minResult);

        scanner.close();
    }

    static void dfs(int add, int sub, int mul, int div, int sum, int idx) {
        if (idx == n) {
            maxResult = Math.max(maxResult, sum);
            minResult = Math.min(minResult, sum);
            return;
        }
        if (add > 0) {
            dfs(add - 1, sub, mul, div, sum + number[idx], idx + 1);
        }
        if (sub > 0) {
            dfs(add, sub - 1, mul, div, sum - number[idx], idx + 1);
        }
        if (mul > 0) {
            dfs(add, sub, mul - 1, div, sum * number[idx], idx + 1);
        }
        if (div > 0) {
            dfs(add, sub, mul, div - 1, sum / number[idx], idx + 1);
        }
    }
}
