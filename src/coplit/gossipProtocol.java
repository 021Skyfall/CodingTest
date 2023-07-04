package coplit;

//세로와 가로의 길이가 각각 M, N인 마을지도가 배열로 주어졌을 때, '1'은 주민이 있는 집을 의미하고 '0'은 주민이 없는 땅을 의미합니다.
// 마을은 소문이 시작되면 하루에 상하좌우 한 칸 바로 옆에 있는 집으로 퍼집니다.
// 특정 주민의 집 (R, C)으로부터 어떤 소문이 시작될 경우, 마을 전체로 소문이 퍼지는데 걸리는 시간(일)을 리턴해야 합니다.

//M, N은 100 이하의 자연수입니다.
//row, col에는 항상 주민이 살고 있습니다.
//모든 집은 연결되어 있습니다. 즉, 한 집에서 다른 집으로 가는 경로가 항상 존재합니다.
//village를 그래프로 구현하는 함수가 주어집니다.

import java.util.Arrays;

public class gossipProtocol {
    // 순화 큐에서 사용할 변수
    static int front = 0;
    static int rear = 0;
    static int[][] queue;

    public static void main(String[] args) {
        String[] village = new String[]{
                "0101", // 첫 번째 줄
                "0111",
                "0110",
                "0100",
        };
        int row = 1;
        int col = 2;
        int output = gossipProtocol(village, row, col);
        System.out.println(output); // --> 3
/*
1. 시작: (1, 2)에서 시작, 소문이 퍼진 곳을 x로 표기
 [
  "0101",
  "01x1",
  "0110",
  "0100",
 ]

2. 1일 뒤
 [
  "0101",
  "0xxx",
  "01x0",
  "0100",
 ]

3. 2일 뒤
 [
  "0x0x",
  "0xxx",
  "0xx0",
  "0100",
 ]

4. 3일 뒤: 소문이 전부 퍼짐 (끝)
 [
  "0x0x",
  "0xxx",
  "0xx0",
  "0x00",
 ]
*/
    }
    private static int gossipProtocol(String[] village, int row, int col) {
        // bfs 구현을 위해 큐를 선언
        // enQueue, deQueue시 마다 인덱싱을 다시 하지 않기 위해
        // 순환 큐로 구현
        // queue의 가능한 최대 크기만큼 배열 선언
        // 문제의 특성에 따라 큐에는 좌표 평면의 한 점이 삽입되고, 한번 삽입된 요소는 두 번 다시 삽입되지 않음
        int R = village.length;
        int C = village[0].length();
        int[][] matrix = createdMatrix(village);
        int[][] MOVES = new int[][] {
                {-1, 0}, // UP
                {1, 0}, // DOWN
                {0, 1}, // RIGHT
                {0, -1} // LEFT
        };

        int MAX_SIZE = R * C;
        queue = new int[MAX_SIZE][];
        int cnt = 0;
        enQueue(queue, new int[]{row, col}, MAX_SIZE);

        // 소문이 퍼지는 데 걸리는 시간을 저장
        matrix[row][col] = 0;
        while (isEmpty()) {
            // 큐의 가장 앞 자리의 좌표를 얻음
            int[] pos = deQueue(queue, MAX_SIZE);
            row = pos[0];
            col = pos[1];
            cnt = matrix[row][col];

            // 현재 지점을 기준으로 네 방향을 검토함
            for (int[] move : MOVES) {
                int rDiff = move[0];
                int cDiff = move[1];
                int nextRow = row + rDiff;
                int nextCol = col + cDiff;
                if (isValid(nextRow, nextCol, R, C) && matrix[nextRow][nextCol] == 1) {
                    enQueue(queue, new int[]{nextRow, nextCol}, MAX_SIZE);
                    matrix[nextRow][nextCol] = matrix[row][col] + 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        return cnt;
    }
    private static void enQueue(int[][] queue, int[] pos, int MAX_SIZE) {
        // 실행 중에 큐가 가득차지 않기 때문에 별도의 조건물을 작성할 필요가 없음
        queue[rear] = pos;
        // 모듈러스 연산을 할 필요도 없긴함
        rear = (rear + 1) % MAX_SIZE;
    }
    private static boolean isEmpty() {
        return front != rear;
    }
    private static int[] deQueue(int[][] queue, int MAX_SIZE) {
        int[] pos = queue[front];
        front = (front + 1) % MAX_SIZE;
        return pos;
    }
    private static boolean isValid(int row, int col, int R, int C) {
        return row >= 0 && row < R && col >= 0 && col < C;
    }
    private static int[][] createdMatrix(String[] village) {
        int[][] matrix = new int[village.length][];
        for (int i = 0; i < village.length; i++) {
            String str = village[i];
            int[] row = new int[str.length()];
            for (int j = 0; j < str.length(); j++) {
                row[j] = Character.getNumericValue(str.charAt(j));
            }
            matrix[i] = row;
        }
        return matrix;
    }
}