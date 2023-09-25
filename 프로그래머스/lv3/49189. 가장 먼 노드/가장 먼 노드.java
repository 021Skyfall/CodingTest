import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int ne : graph.get(node)) {
                if (dist[ne] == -1) {
                    dist[ne] = dist[node] + 1;
                    q.offer(ne);
                }
            }
        }

        int maxDist = Arrays.stream(dist).max().getAsInt();

        int answer = 0;
        for (int distance : dist) {
            if (distance == maxDist) {
                answer++;
            }
        }

        return answer;
    }
}