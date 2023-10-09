import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
                // 요청시간 정렬
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        // 처리시간 정렬 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        // 순서대로 답, 입력된 배열의 인덱스, 요청 갯수, 총 시간(평균 구하기 위함), 수행 후 시간
        int answer = 0, index = 0, count = 0, total = 0, end = 0;

        // 요청 모두 수행될 때까지 반복
        while (count < jobs.length) {
            // 하나의 작업이 완료되는 시점까지 모든 요청을 큐에 삽입
            while (index < jobs.length && jobs[index][0] <= end) {
                pq.add(jobs[index++]);
            }
            // 큐가 비어있다면 작업 완료 이후 다시 요청이 들어옴
            if (pq.isEmpty()) {
                // end를 요청의 시작으로 변경
                end = jobs[index][0];

            } else { // 작업이 끝나기 전 들어온 요청 중 가장 수행시간이 짧은 요청부터 시작
                int[] cur = pq.poll();
                total += cur[1] + end - cur[0];
                end += cur[1];
                count++;
            }
        }
        return total / jobs.length;
    }
}