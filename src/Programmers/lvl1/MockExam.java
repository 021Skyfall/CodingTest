package Programmers.lvl1;

import java.util.ArrayList;
import java.util.Arrays;

public class MockExam {
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};

        int[] result = solution(answers);

        // 결과 출력
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] answers) {
        // 수험생의 답안 패턴
        int[][] patterns = {
                {1, 2, 3, 4, 5}, // 1번 수험생
                {2, 1, 2, 3, 2, 4, 2, 5}, // 2번 수험생
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} // 3번 수험생
        };

        int[] scores = new int[3]; // 각 수험생의 점수

        // 각 수험생의 점수 계산
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }

        // 최대 점수 찾기
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        // 최대 점수를 받은 수험생의 번호를 리스트에 저장
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                result.add(i + 1); // 수험생 번호는 1부터 시작
            }
        }

        // 결과를 배열로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}
