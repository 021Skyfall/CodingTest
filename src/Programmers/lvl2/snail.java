package Programmers.lvl2;

import java.util.*;

public class snail {
    public static void main(String[] args) {
        int n = 4; // 예시 입력
        int[] result = solution(n);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] solution(int n) {
        // 삼각형 배열을 초기화
        int[][] triangle = new int[n][n];
        int num = 1; // 채울 숫자
        int x = -1, y = 0; // 초기 위치 설정

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) { // 아래로 이동
                    x++;
                } else if (i % 3 == 1) { // 오른쪽으로 이동
                    y++;
                } else { // 위쪽 대각선으로 이동
                    x--;
                    y--;
                }
                triangle[x][y] = num++;
            }
        }

        // 결과 배열을 ArrayList로 변환 후, 다시 int 배열로 변환
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                resultList.add(triangle[i][j]);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
