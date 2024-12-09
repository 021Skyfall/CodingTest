package baekjoon.분할정복;

import java.util.Scanner;

public class BJ_1992 {
    static int[][] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        arr = new int[n][n];

        // 배열 입력 받기
        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        division(0, 0, n);

        scanner.close();
    }

    static void division(int startRow, int startCol, int size) {
        if (size == 1) {
            System.out.print(arr[startRow][startCol]);
            return;
        }

        int num = arr[startRow][startCol];

        for (int row = startRow; row < startRow + size; row++) {
            for (int col = startCol; col < startCol + size; col++) {
                if (num != arr[row][col]) {
                    System.out.print("(");
                    size /= 2;
                    division(startRow, startCol, size); // 왼쪽 위
                    division(startRow, startCol + size, size); // 오른쪽 위
                    division(startRow + size, startCol, size); // 왼쪽 아래
                    division(startRow + size, startCol + size, size); // 오른쪽 아래
                    System.out.print(")");
                    return;
                }
            }
        }

        System.out.print(num);
    }
}
