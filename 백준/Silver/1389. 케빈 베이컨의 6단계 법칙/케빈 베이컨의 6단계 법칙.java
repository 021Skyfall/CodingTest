import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int v, e, INF = 1000000;

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken()); // 정점의 개수
        e = Integer.parseInt(st.nextToken()); // 간선의 개수

        arr = new int[v + 1][v + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) continue;
                if (arr[i][j] == 0) arr[i][j] = INF;
            }
        }

        floydWarshall();

        int minIndex = 1; // 최소 케빈 베이컨 수를 가진 사용자의 인덱스
        int minBacon = Integer.MAX_VALUE; // 최소 케빈 베이컨 수

        for (int i = 1; i <= v; i++) {
            int bacon = 0; // i번째 사용자의 케빈 베이컨 수

            for (int j = 1; j <= v; j++) {
                bacon += arr[i][j];
            }

            if (bacon < minBacon) {
                minBacon = bacon;
                minIndex = i;
            }
        }

        System.out.println(minIndex); // 최소 케빈 베이컨 수를 가진 사용자의 인덱스

    }
    // 모든 쌍의 거리를 구하는 함수
    public static void floydWarshall() {
        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (arr[i][k] != 0 && arr[k][j] != 0) {
                        if (arr[i][j] == 0)
                            arr[i][j] = arr[i][k] + arr[k][j];
                        else
                            arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }
    }
}