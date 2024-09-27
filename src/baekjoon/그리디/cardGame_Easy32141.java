package baekjoon.그리디;

import java.util.*;

public class cardGame_Easy32141 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int H = sc.nextInt();
        int[] d = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            d[i] = sc.nextInt();
        }

        long[] S = new long[N + 1];
        for (int k = 1; k <= N; k++) {
            S[k] = S[k - 1] + d[k];
        }

        if (H > S[N]) {
            System.out.println(-1);
        } else {
            for (int i = 1; i <= N; i++) {
                if (H <= S[i]) {
                    System.out.println(i);
                    break;
                }
            }
        }
        sc.close();
    }
}
