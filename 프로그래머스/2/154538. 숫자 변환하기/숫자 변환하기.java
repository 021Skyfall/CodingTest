import java.util.*;


class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];

        queue.add(x);
        visited[x] = true;
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == y) {
                    return step;
                }

                if (current + n <= y && !visited[current + n]) {
                    queue.add(current + n);
                    visited[current + n] = true;
                }
                if (current * 2 <= y && !visited[current * 2]) {
                    queue.add(current * 2);
                    visited[current * 2] = true;
                }
                if (current * 3 <= y && !visited[current * 3]) {
                    queue.add(current * 3);
                    visited[current * 3] = true;
                }
            }
            step++;
        }

        return -1;
    }
}