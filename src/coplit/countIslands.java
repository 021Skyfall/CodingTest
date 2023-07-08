package coplit;

// 세로와 가로의 길이가 각각 R, M인 2차원 R X M 배열 grid가 주어졌을 때,
// '1'은 땅을 의미하고 '0' 은 물을 의미합니다.
// 주어진 2차원 배열에 존재하는 섬의 개수를 리턴해야 합니다.

//섬이란 물로 둘러싸여 있는 땅을 말합니다.
//가로 혹은 세로로 땅이 연결되어 있는 경우 하나의 섬으로 간주합니다.
//2차원 배열의 범위 밖은 물로 둘러싸여 있다고 가정합니다.

public class countIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'1', '1', '0', '0'},
        };
        int result = countIslands(grid);
        System.out.println(result); // --> 1

        grid = new char[][]{
                {'0', '1', '1', '1', '0'},
                {'0', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'}
        };
        result = countIslands(grid);
        System.out.println(result); // --> 3
    }
    private static int countIslands(char[][] grid) {
        //dfs
        int HEIGHT = grid.length;
        if (HEIGHT == 0) return 0;
        int WIDTH = grid[0].length;
        int count = 0;

        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                if (grid[row][col] == '0') continue;;
                count++;
                grid = searchIsland(row,col,HEIGHT,WIDTH,grid);
            }
        }
        return count;
    }
    private static char[][] searchIsland(int row, int col, int HEIGHT, int WIDTH, char[][] grid) {
        if (row < 0 || col < 0 || row >= HEIGHT || col >= WIDTH) return grid;
        if (grid[row][col] == '0') return grid;

        grid[row][col] = '0';
        grid = searchIsland(row - 1, col, HEIGHT, WIDTH, grid);
        grid = searchIsland(row + 1, col, HEIGHT, WIDTH, grid);
        grid = searchIsland(row, col - 1, HEIGHT, WIDTH, grid);
        grid = searchIsland(row, col + 1, HEIGHT, WIDTH, grid);
        return grid;
    }
}
