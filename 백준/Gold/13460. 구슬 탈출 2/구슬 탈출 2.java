import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] map;
    static boolean[][][][] visited; // 적구, 청구 2개 -> 각 x,y 좌표 방문 여부
    static int holeX, holeY;
    static Marble blue, red;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    static class Marble {
        // 레드
        int rx;
        int ry;
        // 블루
        int bx;
        int by;
        // 이동
        int cnt;
        public Marble(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m][n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                } else if(map[i][j] == 'B') {
                    blue = new Marble(0, 0, i, j, 0);
                } else if(map[i][j] == 'R') {
                    red = new Marble(i, j, 0, 0, 0);
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Marble> q = new LinkedList<>();
        q.offer(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
        visited[red.rx][red.ry][blue.rx][blue.ry] = true;

        while(!q.isEmpty()) {
            Marble marble = q.poll();

            int curRx = marble.rx;
            int curRy = marble.ry;
            int curBx = marble.bx;
            int curBy = marble.by;
            int curCnt = marble.cnt;

            // 조건 : 이동 횟수 10회 미만
            if (curCnt > 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isRed = false;
                boolean isBlue = false;

                // 적구 이동
                while (map[newRx + dx[i]][newRy + dy[i]] != '#') {
                    newRx += dx[i];
                    newRy += dy[i];
                    // 구멍 도달
                    if (newRx == holeX && newRy == holeY) {
                        isRed = true;
                        break;
                    }
                }

                // 청구 이동
                while(map[newBx + dx[i]][newBy + dy[i]] != '#') {
                    newBx += dx[i];
                    newBy += dy[i];

                    // 구멍 도달
                    if (newBx == holeX && newBy == holeY) {
                        isBlue = true;
                        break;
                    }
                }

                if (isBlue) { // 청구 구멍 도달 시 실패
                    continue; // 다른 경우의 수로
                }
                if (isRed && !isBlue) { // 무조건 성공 분기
                    return curCnt;
                }

                // 두 구슬이 구멍 도달 X 이동 위치가 같은 경우 조정
                if (newRx == newBx && newRy == newBy) {
                    if (i == 0) { // 위
                        // 더 큰 x값을 가지는 구슬이 뒤로
                        if (curRx > curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else if (i == 1) { // 우
                        // 더 작은 y값을 가지는 구슬이 뒤로
                        if (curRy < curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    } else if (i == 2) { // 하
                        // 더 작은 x값을 가지는 구슬이 뒤로
                        if (curRx < curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else { // 좌
                        // 더 큰 y값을 가지는 구슬이 뒤로
                        if (curRy > curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    }
                }

                // 두 구슬이 이동할 위치가 방문하지 않았던 곳인 경우 이동
                if (!visited[newRx][newRy][newBx][newBy]) {
                    visited[newRx][newRy][newBx][newBy] = true;
                    q.offer(new Marble(newRx, newRy, newBx, newBy, curCnt + 1));
                }
            }
        }
        return -1;
    }
}