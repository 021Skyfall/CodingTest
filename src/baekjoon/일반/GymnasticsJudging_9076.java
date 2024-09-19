package baekjoon.일반;

import java.util.*;

public class GymnasticsJudging_9076 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // 테스트 케이스 수
        for (int t = 0; t < T; t++) {
            int[] scores = new int[5];
            for (int i = 0; i < 5; i++) {
                scores[i] = scanner.nextInt(); // 점수 입력
            }

            // 점수 배열 정렬
            Arrays.sort(scores);

            // 최고점과 최저점 제외
            int totalScore = scores[1] + scores[2] + scores[3];

            // 최고점과 최저점의 차이 계산
            if (scores[3] - scores[1] >= 4) {
                System.out.println("KIN");
            } else {
                System.out.println(totalScore);
            }
        }

        scanner.close();
    }
}
