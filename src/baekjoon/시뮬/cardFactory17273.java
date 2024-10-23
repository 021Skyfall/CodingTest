package baekjoon.시뮬;

import java.util.Scanner;

public class cardFactory17273 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] front = new int[N];
        int[] back = new int[N];
        int[] result = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            front[i] = scanner.nextInt();
            back[i] = scanner.nextInt();
            result[i] = front[i];  // 초기값 설정
        }

        while (M-- > 0) {
            int K = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                // 뒤집기
                if (result[i] <= K) {
                    result[i] = (result[i] == front[i]) ? back[i] : front[i];
                }
            }
        }

        for (int value : result) {
            sum += value;
        }

        System.out.println(sum);
        scanner.close();
    }
}
