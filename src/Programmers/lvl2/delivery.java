package Programmers.lvl2;

import java.util.*;

public class delivery {
    public static int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int box = 1; box <= order.length; box++) {
            stack.push(box);
            while (!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop();
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};
        System.out.println(solution(order));
    }
}
