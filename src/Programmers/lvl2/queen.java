package Programmers.lvl2;

public class queen {
    private int count = 0;

    public int solution(int n) {
        int[] board = new int[n];
        placeQueens(board, 0, n);
        return count;
    }

    private void placeQueens(int[] board, int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            board[row] = col;
            if (isValid(board, row)) {
                placeQueens(board, row + 1, n);
            }
        }
    }

    private boolean isValid(int[] board, int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row] || Math.abs(board[i] - board[row]) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
