class Solution {
    public int[] solution(int brown, int yellow) {
        int totalTiles = brown + yellow; // 전체 타일의 개수

        for (int height = 3; height <= totalTiles / 3; height++) {
            if (totalTiles % height == 0) {
                int width = totalTiles / height;
                if ((width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }
        return new int[]{};
    }
}