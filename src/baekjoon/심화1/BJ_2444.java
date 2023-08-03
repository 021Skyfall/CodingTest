package baekjoon.심화1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2444 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

//        // 위쪽 부분 출력
//        for (int i = 1; i <= n; i += 2) {
//            conditions(n, i);
//        }
//
//        // 아래쪽 부분 출력
//        for (int i = n - 2; i >= 1; i -= 2) {
//            conditions(n, i);
//        }
//    }
//
//    private static void conditions(int n, int i) {
//        for (int j = 0; j < (n - i) / 2; j++) {
//            System.out.print(" ");
//        }
//        for (int j = 0; j < i; j++) {
//            System.out.print("*");
//        }
//        System.out.println();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            conditions(n, sb, i);
        }
        for (int i = n-1; i >= 1; i--) {
            conditions(n, sb, i);
        }

        System.out.println(sb);
    }

    private static void conditions(int n, StringBuilder sb, int i) {
        for (int j = 1; j <= n - i; j++) {
            sb.append(" ");
        }
        for (int j = 1; j <= 2*i-1; j++) {
            sb.append("*");
        }
        sb.append("\n");
    }
}
