package coplit;

//스도쿠는 숫자 퍼즐로, 가로 9칸, 세로 9칸으로 이루어져 있는 표에 1부터 9까지의 숫자를 채워 넣는 퍼즐입니다.
// 퍼즐을 푸는 방법은 아홉 가로줄, 세로줄, 3X3 칸에 1에서 9까지의 숫자를 중복되지 않게 한 번씩만 넣으면 됩니다.
// 일부 칸이 비어있는 상태인 스도쿠 보드를 입력받아 스도쿠 퍼즐이 완성된 보드를 리턴해야 합니다.

//입력으로 주어지는 board를 직접 수정해도 상관없습니다.
//입력으로 주어지는 board 가지고 완성시킬 수 있는 보드는 유일(unique)합니다.
//숫자가 입력되지 않은 칸은 편의상 0이 입력되어 있습니다.

import java.util.ArrayList;
import java.util.Arrays;

public class sudoku {
    static int[][] result;
    static boolean[][] rowCheck, colCheck, squCheck;
    static ArrayList<int[]> blanks;

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 3, 0, 2, 6, 0, 7, 0, 1},
                {6, 8, 0, 0, 7, 0, 0, 9, 0},
                {1, 9, 0, 0, 0, 4, 5, 0, 0},
                {8, 2, 0, 1, 0, 0, 0, 4, 0},
                {0, 0, 4, 6, 0, 2, 9, 0, 0},
                {0, 5, 0, 0, 0, 3, 0, 2, 8},
                {0, 0, 9, 3, 0, 0, 0, 7, 4},
                {0, 4, 0, 0, 5, 0, 0, 3, 6},
                {7, 0, 3, 0, 1, 8, 0, 0, 0}
        };
        int[][] output = sudoku(board);
        System.out.println(Arrays.deepToString(output)); // -->
/*
[
  [4, 3, 5, 2, 6, 9, 7, 8, 1],
  [6, 8, 2, 5, 7, 1, 4, 9, 3],
  [1, 9, 7, 8, 3, 4, 5, 6, 2],
  [8, 2, 6, 1, 9, 5, 3, 4, 7],
  [3, 7, 4, 6, 8, 2, 9, 1, 5],
  [9, 5, 1, 7, 4, 3, 6, 2, 8],
  [5, 1, 9, 3, 2, 6, 8, 7, 4],
  [2, 4, 8, 9, 5, 7, 1, 3, 6],
  [7, 6, 3, 4, 1, 8, 2, 5, 9]
];
 */
    }

    private static int[][] sudoku(int[][] board) {
        // 결과를 담을 배열
        result = new int[9][9];
        // 가로, 세로, 3X3 방문 여부를 확인할 배열
        rowCheck = new boolean[9][10];
        colCheck = new boolean[9][10];
        squCheck = new boolean[9][10];
        // 채워야 할 빈칸을 넣어줄 List 선언
        blanks = new ArrayList<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                result[row][col] = board[row][col];
                // 빈칸일 경우 List에 해당 row, col을 삽입
                if (result[row][col] == 0) blanks.add(new int[]{row, col});
                else {
                    // 빈칸이 아닐 경우, 이미 방문함
                    rowCheck[row][result[row][col]] = true;
                    colCheck[col][result[row][col]] = true;
                    squCheck[(row / 3 * 3) + (col / 3)][result[row][col]] = true;
                }
            }
        }
        // 빈칸을 순회하며 맞는 숫자를 넣기 위한 메서드
        tracking(0);
        return result;
    }

    private static boolean tracking(int count) {
        // 현재 List 크기와 count 가 같은 경우는 모든 빈칸을 다 채웠을 경우
        if (count == blanks.size()) return true;
        int[] data = blanks.get(count);
        int row = data[0];
        int col = data[1];

        // 빈칸에 1부터 9까지의 숫자를 모두 넣어보고
        for (int i = 1; i <= 9; i++) {
            // 해당 숫자가 가로, 세로, 3X3 구역에 이미 사용되고 있다면
            if (rowCheck[row][i] || colCheck[col][i] || squCheck[row / 3 * 3 + (col / 3)][i]) continue;

            // 포함되어 있지 않아서, 숫자를 삽입 가능하다면
            rowCheck[row][i] = true;
            colCheck[col][i] = true;
            squCheck[row / 3 * 3 + (col / 3)][i] = true;
            result[row][col] = i;

            // 다음 빈칸으로 넘어감
            if (tracking(count + 1)) return true;

            // 다시 원상복구
            // 이전의 결과가 이후의 결과에 미치는 영향을 지우기 위함
            rowCheck[row][i] = false;
            colCheck[col][i] = false;
            squCheck[row / 3 * 3 + (col / 3)][i] = false;
            result[row][col] = 0;
        }
        return false;
    }
}
