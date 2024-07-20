package Programmers.lvl1;

import java.util.ArrayList;
import java.util.Collections;

public class HOF1 {
    public static void main(String[] args) {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 200};

        int[] result = solution(k, score);

        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> hallOfFame = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            hallOfFame.add(score[i]); // 점수 추가
            hallOfFame.sort(Collections.reverseOrder()); // 내림차순 정렬

            // 명예의 전당의 크기를 k로 제한
            if (hallOfFame.size() > k) {
                hallOfFame.remove(hallOfFame.size() - 1); // 가장 낮은 점수 제거
            }

            // 현재 명예의 전당에서 가장 낮은 점수의 값을 answer에 추가
            answer[i] = hallOfFame.size() < k ? hallOfFame.get(hallOfFame.size() - 1) : hallOfFame.get(k - 1);
        }

        return answer;
    }
}
