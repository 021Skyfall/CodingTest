package baekjoon.수학;

import java.util.Scanner;

public class numszero11170 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            System.out.println(countZeros(N, M));
        }

        scanner.close();
    }

    private static int countZeros(int n, int m) {
        int count = 0;

        for (int i = n; i <= m; i++) {
            String numStr = Integer.toString(i);
            for (char c : numStr.toCharArray()) {
                if (c == '0') {
                    count++;
                }
            }
        }

        return count;
    }
}
