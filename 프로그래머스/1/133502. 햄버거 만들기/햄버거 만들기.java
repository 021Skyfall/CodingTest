import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int ing : ingredient) {
            stack.push(ing);

            if (stack.size() >= 4) {
                if (stack.get(stack.size() - 1) == 1 &&
                        stack.get(stack.size() - 2) == 3 &&
                        stack.get(stack.size() - 3) == 2 &&
                        stack.get(stack.size() - 4) == 1) {
                    count++;

                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }

        return count;
    }
}