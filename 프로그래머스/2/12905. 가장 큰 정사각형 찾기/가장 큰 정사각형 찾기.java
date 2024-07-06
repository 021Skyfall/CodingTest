class Solution
{
    public int solution(int [][]board)
    {
        int maxSide = 0;
        int rows = board.length;
        int cols = board[0].length;

        // DP 테이블 초기화
        int[][] dp = new int[rows][cols];

        // 첫 번째 행과 첫 번째 열을 초기화
        for (int i = 0; i < rows; i++) {
            dp[i][0] = board[i][0];
            maxSide = Math.max(maxSide, dp[i][0]);
        }
        for (int j = 0; j < cols; j++) {
            dp[0][j] = board[0][j];
            maxSide = Math.max(maxSide, dp[0][j]);
        }

        // DP 배열 채우기
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        // 가장 큰 정사각형의 넓이 반환
        return maxSide * maxSide;
    }
}