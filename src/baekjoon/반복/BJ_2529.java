package baekjoon.반복;

import java.util.Scanner;

public class BJ_2529 {
    static int n;
    static char[] b = new char[9];
    static boolean[] c = new boolean[10];
    static String mn = "", mx = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            b[i] = scanner.next().charAt(0);
        }
        solve(0, "");
        System.out.println(mx);
        System.out.println(mn);
        scanner.close();
    }

    static boolean possible(int i, int j, char k) {
        if (k == '<') return i < j;
        if (k == '>') return i > j;
        return true;
    }

    static void solve(int cnt, String s) {
        if (cnt == n + 1) {
            if (mn.isEmpty()) {
                mn = s;
            } else {
                mx = s;
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (c[i]) continue;
            if (cnt == 0 || possible(s.charAt(cnt - 1) - '0', i, b[cnt - 1])) {
                c[i] = true;
                solve(cnt + 1, s + i);
                c[i] = false;
            }
        }
    }
}