class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int currentEnd = 0;

        for (int i = 0; i < section.length; i++) {
            // 현재 섹션의 시작 부분이 현재 덧칠한 마지막 부분보다 크면
            if (section[i] > currentEnd) {
                // 현재 섹션을 덧칠하고, 현재 덧칠한 끝 부분을 업데이트
                currentEnd = section[i] + m - 1; // m만큼 덧칠
                count++; // 덧칠 횟수 증가
            }
        }

        return count;
    }
}