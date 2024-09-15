package Programmers.lvl1;

import java.util.*;

public class DollClaw {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        int answer = 0;

        for (int move : moves) {
            int column = move - 1; // moves는 1-indexed이므로 0-indexed로 변환
            for (int row = 0; row < board.length; row++) {
                if (board[row][column] != 0) { // 인형이 있는 경우
                    int doll = board[row][column];
                    board[row][column] = 0; // 인형을 뽑았으므로 해당 위치를 0으로 변경

                    // 바구니에 인형 추가
                    if (!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop(); // 같은 인형이므로 터뜨림
                        answer += 2; // 터뜨린 인형 개수 추가
                    } else {
                        basket.push(doll); // 바구니에 인형 추가
                    }
                    break; // 한 번의 move로 하나의 인형만 뽑을 수 있으므로 반복 종료
                }
            }
        }

        return answer;
    }
}
