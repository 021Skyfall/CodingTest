package study;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(solution(3, new int[][]{{1,1,0},{1,1,1},{0,1,1}}));
    }


    private static int solution(int n, int[][] computers) {
        int answer = 0;

        // 방문여부
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i,visited,computers);
                bfs(i, visited, computers);
            }
        }

        return answer;
    }

    // DFS
    private static void dfs(int node, boolean[] visited, int[][] computers) {
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[node][i] == 1) {
                dfs(i,visited,computers);
            }
        }
    }

    // BFS
    private static void bfs(int node, boolean[] visited, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.offer(node);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < computers.length; i++) {
                if (!visited[i] && computers[cur][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
