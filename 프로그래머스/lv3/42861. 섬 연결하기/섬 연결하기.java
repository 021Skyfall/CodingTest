import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        int[] parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        return kruskal(costs, parent);
    }

    public static int kruskal(int[][] costs, int[] parent) {
        int cost = 0;
        for (int i = 0; i < costs.length; i++) {
            if (find(parent, costs[i][0]) != find(parent, costs[i][1])) {
                cost += costs[i][2];
                union(parent, costs[i][0], costs[i][1]);
            }
        }

        return cost;
    }

    public static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        else return find(parent, parent[x]);
    }

    public static void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        if (x < y) parent[y] = x;
        else parent[x] = y;
    }
}