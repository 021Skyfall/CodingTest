import java.util.*;

public class Main {
    static int[][] matrix = new int[1024][1024];
    static int n;

    static int divisionConquer(int half, int x, int y) {
        List<Integer> v = new ArrayList<>();
        if (half == 1) {
            v.add(matrix[y][x]);
            v.add(matrix[y][x + 1]);
            v.add(matrix[y + 1][x]);
            v.add(matrix[y + 1][x + 1]);
            Collections.sort(v);
            return v.get(2);
        } 
        else {
            v.add(divisionConquer(half / 2, x, y));
            v.add(divisionConquer(half / 2, x + half, y));
            v.add(divisionConquer(half / 2, x, y + half));
            v.add(divisionConquer(half / 2, x + half, y + half));
            Collections.sort(v);
            return v.get(2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = scanner.nextInt();
        System.out.println(divisionConquer(n / 2, 0, 0));
        scanner.close();
    }
}