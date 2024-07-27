import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        // 점수를 내림차순으로 정렬
        Arrays.sort(score);
        
        int totalProfit = 0;
        
        // 점수를 역순으로 탐색
        for (int i = score.length - m; i >= 0; i -= m) {
            // 최소값을 더해주기 (score[i]는 m번째 과일의 점수)
            totalProfit += score[i] * m;
        }
        
        return totalProfit;
    }
}