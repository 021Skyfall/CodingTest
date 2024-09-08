package Programmers.lvl1;

import java.util.*;

public class DartGame {
    public static void main(String[] args) {

    }

    public static int solution(String dartResult) {
        List<Integer> scores = new ArrayList<>();
        int index = 0;

        while (index < dartResult.length()) {
            int score = 0;

            if (dartResult.charAt(index) == '1' && index + 1 < dartResult.length() && dartResult.charAt(index + 1) == '0') {
                score = 10;
                index += 2;
            } else {
                score = dartResult.charAt(index) - '0';
                index++;
            }

            // 보너스 처리
            char bonus = dartResult.charAt(index);
            if (bonus == 'S') {
                // S는 그대로
                scores.add(score);
            } else if (bonus == 'D') {
                // D는 제곱
                scores.add(score * score);
            } else if (bonus == 'T') {
                // T는 세제곱
                scores.add(score * score * score);
            }
            index++;

            // 옵션 처리
            if (index < dartResult.length()) {
                char option = dartResult.charAt(index);
                if (option == '*') {
                    if (scores.size() > 1) {
                        scores.set(scores.size() - 2, scores.get(scores.size() - 2) * 2); // 이전 점수 두 배
                    }
                    scores.set(scores.size() - 1, scores.get(scores.size() - 1) * 2); // 현재 점수 두 배
                    index++;
                } else if (option == '#') {
                    scores.set(scores.size() - 1, scores.get(scores.size() - 1) * -1);
                    index++;
                }
            }
        }

        int totalScore = 0;
        for (int score : scores) {
            totalScore += score;
        }

        return totalScore;
    }
}
