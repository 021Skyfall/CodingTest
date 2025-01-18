package baekjoon.그리디;

import java.util.Scanner;

public class BJ_1080 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // 줄바꿈 문자 소비

        int[][] arrA = new int[N][M];
        int[][] arrB = new int[N][M];

        // 행렬 A 입력받기
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                arrA[i][j] = line.charAt(j) - '0'; // 문자에서 정수로 변환
            }
        }

        // 행렬 B 입력받기
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                arrB[i][j] = line.charAt(j) - '0'; // 문자에서 정수로 변환
            }
        }

        int cnt = 0;

        // 전체 범위 검사
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                // A와 B가 다를 때 3x3 범위 뒤집기
                if (arrA[i][j] != arrB[i][j]) {
                    cnt++;
                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            arrA[x][y] = 1 - arrA[x][y]; // 뒤집기
                        }
                    }
                }
            }
        }

        // 최종 비교
        boolean isEqual = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arrA[i][j] != arrB[i][j]) {
                    isEqual = false;
                    break;
                }
            }
        }

        // 결과 출력
        if (isEqual) {
            System.out.println(cnt);
        } else {
            System.out.println("-1");
        }

        scanner.close();
    }
}
