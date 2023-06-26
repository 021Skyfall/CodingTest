package coplit;

//세로와 가로의 길이가 각각 M, N인 방의 지도가 2차원 배열로 주어졌을 때,
// 1은 장애물을 의미하고 0 이동이 가능한 통로를 의미합니다.
// 로봇은 지도 위를 일분에 한 칸씩 상하좌우로 이동할 수 있습니다.
// 로봇의 위치와 목표 지점이 함께 주어질 경우, 로봇이 목표 지점까지 도달하는 데 걸리는 최소 시간을 리턴해야 합니다.

//M, N은 20 이하의 자연수입니다.
//src, dst는 항상 로봇이 지나갈 수 있는 통로입니다.
//src에서 dst로 가는 경로가 항상 존재합니다.

public class robotPath {
    public static void main(String[] args) {
        int[][] room = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0}
        };
        int[] src = new int[]{4, 2};
        int[] dst = new int[]{2, 2};
        int output = robotPath(room, src, dst);
        System.out.println(output); // --> 8
    }
    private static int robotPath(int[][] room, int[] src, int[] dst) {
        room = aux(room.length, room[0].length, src, 1, room);
        return room[dst[0]][dst[1]] - 1;
    }
    private static int[][] aux(int x, int y, int[] can, int step, int[][] room) {
        // 현재 위치 지정
        int row = can[0];
        int col = can[1];

        // 엣지케이스 (배열의 범위)
        if (row < 0 || row >= x || col < 0 || col >= y) return room;
        if (room[row][col] == 0 || room[row][col] > step) {
            room[row][col] = step;
        } else { // 1이거나 1이하의 시간으로 통과 가능한 경우
            return room;
        }

        // dfs 4방향 탐색
        // 각각 인덱스로 표현
        aux(x, y, new int[]{row + 1, col}, step + 1, room); // 상
        aux(x, y, new int[]{row - 1, col}, step + 1, room); // 하
        aux(x, y, new int[]{row, col + 1}, step + 1, room); // 좌
        aux(x, y, new int[]{row, col - 1}, step + 1, room); // 우

        return room;
    }
}
