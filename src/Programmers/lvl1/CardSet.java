package Programmers.lvl1;

import java.util.Collections;
import java.util.LinkedList;

public class CardSet {
    public static void main(String[] args) {
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        String result = solution(cards1, cards2, goal);

        // 결과 출력
        System.out.println(result); // "Yes" 또는 "No" 출력
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();

        // 카드 뭉치 1과 카드 뭉치 2의 카드 저장
        Collections.addAll(list1, cards1);
        Collections.addAll(list2, cards2);

        // 목표 카드 뭉치 검증
        for (String card : goal) {
            if (!list1.isEmpty() && list1.peek().equals(card)) {
                list1.poll(); // 카드 뭉치 1에서 제거
            } else if (!list2.isEmpty() && list2.peek().equals(card)) {
                list2.poll(); // 카드 뭉치 2에서 제거
            } else {
                return "No"; // 카드 뭉치에 없는 카드
            }
        }

        return "Yes"; // 모든 카드가 포함됨
    }
}
