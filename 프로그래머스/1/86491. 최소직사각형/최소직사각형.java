class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            // 각 명함의 가로와 세로를 비교하여 큰 값과 작은 값을 정리
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);

            // 최대 너비와 최대 높이를 업데이트
            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }

        return maxWidth * maxHeight;
    }
}