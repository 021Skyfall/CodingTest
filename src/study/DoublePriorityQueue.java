package study;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
    }
    private static int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            String[] arr = operations[i].split(" ");
            if (arr[0].equals("I")) {
                int num = Integer.parseInt(arr[1]);
                minQ.add(num);
                maxQ.add(num);
            } else if (arr[0].equals("D")) {
                if (arr[1].equals("1")) {
                    if (!minQ.isEmpty()) {
                        int num = maxQ.poll();
                        minQ.remove(num);
                    }
                } else if (arr[1].equals("-1")) {
                    if (!minQ.isEmpty()) {
                        int num = minQ.poll();
                        maxQ.remove(num);
                    }
                }
            }
        }

        if (minQ.isEmpty() && maxQ.isEmpty()) {
            return new int[]{0, 0};
        } else {
            int max = maxQ.isEmpty() ? 0 : maxQ.poll();
            int min = minQ.isEmpty() ? 0 : minQ.poll();
            return new int[]{max, min};
        }
    }
}
