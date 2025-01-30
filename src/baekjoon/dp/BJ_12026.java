package baekjoon.dp;

import java.util.Scanner;

public class BJ_12026 {
    static int N;
    static char[] street = new char[1001];
    static int[] DP = new int[1001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 소비

        String input = scanner.nextLine(); // 한 줄 전체를 읽기
        for (int i = 1; i <= N; i++) {
            street[i] = input.charAt(i - 1); // 입력된 문자열에서 문자 가져오기
        }

        for (int i = 0; i < 1001; i++) {
            DP[i] = 9999999; // 큰 값으로 초기화
        }

        DP[1] = 0;

        for (int i = 1; i < N; i++) {
            if (street[i] == 'B') {
                for (int j = i + 1; j <= N; j++) {
                    if (street[j] == 'O') {
                        DP[j] = Math.min(DP[j], (j - i) * (j - i) + DP[i]);
                    }
                }
            } else if (street[i] == 'O') {
                for (int j = i + 1; j <= N; j++) {
                    if (street[j] == 'J') {
                        DP[j] = Math.min(DP[j], (j - i) * (j - i) + DP[i]);
                    }
                }
            } else {
                for (int j = i + 1; j <= N; j++) {
                    if (street[j] == 'B') {
                        DP[j] = Math.min(DP[j], (j - i) * (j - i) + DP[i]);
                    }
                }
            }
        }

        if (DP[N] == 9999999) {
            System.out.println(-1);
        } else {
            System.out.println(DP[N]);
        }

        scanner.close();
    }
}
