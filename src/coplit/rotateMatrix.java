package coplit;

// 2차원 N x N 배열을 시계 방향으로 90도 회전시킨 배열을 리턴해야 합니다.

//이때 matrix[i][j]는 '행(세로축)을 기준으로 i만큼 아래에 있고 열(가로축)을 기준으로 j만큼 옆에 있다.`를 뜻합니다.
// 이 방식은 기하학에서 좌표 평면 위의 한 점을 나타낼 때 (x, y), 즉 가로축을 먼저 표기하고 세로축을 다음에 표기하는 방식과는 다릅니다.
// 그래프를 인접행렬로 구현할 때, 이 점을 주의하셔야 합니다.

public class rotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int K = 1;

        System.out.println(matrix[0][0]); // --> 1
        System.out.println(matrix[3][2]); // --> 15

        int[][] rotatedMatrix = rotateMatrix(matrix, K);
        System.out.println(rotatedMatrix[0][0]); // --> 13
        System.out.println(rotatedMatrix[3][2]); // --> 8
    }
    private static int[][] rotateMatrix(int[][] matrix, int K) {
        while(K > 0) {
            K --;
            matrix = rotate(matrix);
        }
        return matrix;
    }

    private static int[][] rotate(int[][] matrix) {
        // 빈 배열 엣지 케이스
        if (matrix == null) return null;
        // 전달받는 2차원 배열 matrix가 K 만큼 시계 방향으로 90도 회전
        int n = matrix.length; // row
        int m = matrix[0].length; // col
        int[][] rotate = new int[m][n]; // 크기만큼 2차원 배열 생성
        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = matrix[n - 1 - j][i];
            }
        }
        return rotate;
    }
}
