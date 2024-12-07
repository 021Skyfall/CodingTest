package baekjoon.경로;

import java.util.Scanner;

public class BJ_12852 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] mem = new int[N + 1];
        String[] path = new String[N + 1];
        path[1] = "1";

        for (int idx = 2; idx <= N; idx++) {
            mem[idx] = mem[idx - 1] + 1;
            int prev = idx - 1;

            if (idx % 3 == 0 && mem[idx / 3] + 1 < mem[idx]) {
                mem[idx] = mem[idx / 3] + 1;
                prev = idx / 3;
            }
            if (idx % 2 == 0 && mem[idx / 2] + 1 < mem[idx]) {
                mem[idx] = mem[idx / 2] + 1;
                prev = idx / 2;
            }
            path[idx] = idx + " " + path[prev];
        }

        System.out.println(mem[N]);
        System.out.println(path[N]);

        scanner.close();
    }
}
