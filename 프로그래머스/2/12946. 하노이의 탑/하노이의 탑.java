import java.util.*;

class Solution {
    public int[][] solution(int n) {
        List<int[]> result = new ArrayList<>();
        hanoi(n, 1, 3, 2, result);
        return result.toArray(new int[result.size()][]);
    }

    private void hanoi(int n, int from, int to, int aux, List<int[]> result) {
        if (n == 1) {
            result.add(new int[]{from, to});
            return;
        }
        hanoi(n - 1, from, aux, to, result);
        result.add(new int[]{from, to});
        hanoi(n - 1, aux, to, from, result);
    }
}