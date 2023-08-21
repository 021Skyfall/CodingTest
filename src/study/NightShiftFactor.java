package study;

import java.util.Collections;
import java.util.PriorityQueue;

public class NightShiftFactor {
    public static void main(String[] args) {
        System.out.println(solution(4,new int[]{4,3,3}));
        System.out.println(solution(1,new int[]{2,1,2}));
        System.out.println(solution(3,new int[]{1,1}));
    }
    private static long solution(int n, int[] works) {
        PriorityQueue<Integer> time = new PriorityQueue<>(Collections.reverseOrder());

        // 큐 값 삽입
        for (int work : works) {
            time.offer(work);
        }

        for (int i = 0; i < n; i++) {
            int max = time.poll();
            if (max <= 0) break;
            time.offer(max - 1);
        }

        return sumPow(time);
    }

    private static long sumPow(PriorityQueue<Integer> works) {
        long sum = 0;
        while (!works.isEmpty())
            sum += Math.pow(works.poll(), 2);

        return sum;
    }
}
