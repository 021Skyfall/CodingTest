import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> chs = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!chs.isEmpty() && chs.peek() == c) {
                chs.pop();
            } else {
                chs.push(c);
            }
        }
        return chs.isEmpty() ? 1 : 0;
    }
}