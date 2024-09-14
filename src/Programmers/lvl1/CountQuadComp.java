package Programmers.lvl1;

public class CountQuadComp {
    private int[] answer = new int[2]; // [0의 개수, 1의 개수]

    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }

    private void compress(int[][] arr, int x, int y, int size) {
        if (isUniform(arr, x, y, size)) {
            answer[arr[x][y]]++; // 모든 값이 같으면 해당 값의 카운트 증가
            return;
        }

        // 쿼드 압축
        int newSize = size / 2;
        compress(arr, x, y, newSize); // 좌상
        compress(arr, x, y + newSize, newSize); // 우상
        compress(arr, x + newSize, y, newSize); // 좌하
        compress(arr, x + newSize, y + newSize, newSize); // 우하
    }

    private boolean isUniform(int[][] arr, int x, int y, int size) {
        int firstValue = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != firstValue) {
                    return false; // 하나라도 다르면 false
                }
            }
        }
        return true; // 모두 같으면 true
    }
}
