package coplit;

//2차원 M x N 배열을 나선형(spiral)으로 순회해야 합니다.

//순회는 좌측 상단 (0,0)에서 시작합니다.
//배열의 모든 요소를 순서대로 이어붙인 문자열을 리턴해야 합니다.

public class spiralTraversal {
    public static void main(String[] args) {
        Character[][] matrix = new Character[][]{
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'},
        };
        String output = spiralTraversal(matrix);
        System.out.println(output); // --> "ABCFIHGDE"

        matrix = new Character[][]{
                {'T', 'y', 'r', 'i'},
                {'i', 's', 't', 'o'},
                {'n', 'r', 'e', 'n'},
                {'n', 'a', 'L', ' '},
        };
        output = spiralTraversal(matrix);
        System.out.println(output); // --> 'Tyrion Lannister'
    }
    private static String spiralTraversal(Character[][] matrix) {
        String result = "";
        if (matrix.length == 0) return null;

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int x = 0, y = 0, div = 0;

        for (int i = 0; i < m * n; i++) {
            result += matrix[x][y];
            visited[x][y] = true;
            int cr = x + dr[div];
            int cc = y + dc[div];

            if (0 <= cr && cr < m && 0 <= cc && cc < n && !visited[cr][cc]) {
                x = cr;
                y = cc;
            } else {
                div = (div + 1) % 4;
                x += dr[div];
                y += dc[div];
            }
        }
        return result;
    }
}
