package Programmers.lvl2.greedy;

import java.util.*;

public class biggerInt {
    public static void main(String[] args) {
        String number = "1924";
        int k = 2;
        String result = solution(number, k);
        System.out.println(result);  // 출력 예시: "94"
    }

    public static String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // 만약 아직 제거해야 할 숫자가 남아있다면 뒤에서부터 제거
        while (k > 0) {
            stack.pop();
            k--;
        }

        // 스택을 문자열로 변환
        StringBuilder answer = new StringBuilder();
        for (char c : stack) {
            answer.append(c);
        }

        return answer.toString();
    }
}
