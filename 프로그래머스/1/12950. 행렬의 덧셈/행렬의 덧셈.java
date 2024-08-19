class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rows = arr1.length;
        int cols = arr1[0].length;

        int[][] result = new int[rows][cols]; // 결과 행렬 초기화

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = arr1[i][j] + arr2[i][j]; // 같은 위치의 요소를 더함
            }
        }

        return result;
    }
}