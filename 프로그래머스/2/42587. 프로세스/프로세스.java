import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        // 큐와 우선순위 큐 초기화
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
            priorityQueue.add(priorities[i]);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Process current = queue.poll();

            // 현재 프로세스가 가장 높은 중요도를 가지면 처리
            if (current.priority == priorityQueue.peek()) {
                count++;
                priorityQueue.poll();
                if (current.index == location) {
                    return count;
                }
            } else {
                // 그렇지 않으면 다시 큐에 삽입
                queue.add(current);
            }
        }

        return -1;  // 이 경우는 존재하지 않음
    }

    class Process {
        int index;
        int priority;

        Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}