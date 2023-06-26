package coplit;

// 문자열을 입력받아 문자열 내의 모든 괄호의 짝이 맞는지 여부를 리턴해야 합니다.
//
//다음 단계에 맞춰 함수를 작성해 보세요
//괄호의 종류를 단 한가지로 한정합니다.
//괄호의 종류를 늘려 모든 종류의 괄호에도 작동하도록 합니다.
//괄호를 제외한 문자열이 포함된 경우에도 작동하도록 합니다.
//괄호는 닫힌 괄호 ), ], } 가 시작되면, 이후로 추가적인 열린 괄호가 앞에 존재하지 않은 경우 닫힌 괄호가 입력될 수 없습니다 (이럴 경우 실패)
//ex) balancedBrackets ')(' 혹은 balancedBrackets '())()(()'과 같은 입력은 항상 false입니다

//괄호는 먼저 열리고((), 열린만큼만 닫혀야()) 합니다.
//빈 문자열을 입력받은 경우, true를 리턴해야 합니다.

import java.util.HashMap;
import java.util.Stack;

public class balancedBrackets {
    public static void main(String[] args) {
        boolean output = balancedBrackets("[](){}");
        System.out.println(output); // --> true

        boolean output2 = balancedBrackets("[({})]");
        System.out.println(output2); // --> true

        boolean output3 = balancedBrackets("[(]{)}");
        System.out.println(output3); // --> false
    }
    private static boolean balancedBrackets(String str) {
        Stack<String> box = new Stack<>();
        // for -> str 탐색
        for (int i = 0; i < str.length(); i++) {
            // 캐릭터 저장
            char start = str.charAt(i);
            // 시작 괄호면 push
            if (start == '(' || start == '[' || start == '{') {
                box.push(String.valueOf(start));
            } else {
                // 연산 중간에 스택이 비어버리면 시작 괄호가 없는 것
                if (box.size() == 0) return false;
                // 종료 괄호라면 시작 괄호와 매칭 되는지 확인 -> 된다면 pop
                else if (start == ')' && box.contains("(") ||
                start == '}' && box.contains("{") ||
                start == ']' && box.contains("[")) {
                    box.pop();
                }
            }
        }
        // 스택 길이가 0이 된다면 전부 매칭
        // 아니라면 남은게 있음
        return box.size() == 0;
    }
    private static boolean balancedBrackets1(String str) {
        Stack<Character> stack = new Stack<>();
        // hashmap 선언 후 쌍이 맞는 괄호를 키와 값으로 할당
        HashMap<Character, Character> opener = new HashMap<>();
        opener.put('{', '}');
        opener.put('[', ']');
        opener.put('(', ')');

        // 괄호의 뒷부분을 따로 String으로 선언
        String closer = "})]";

        // 입력받은 문자열을 모두 순회
        for (int i = 0; i < str.length(); i++) {
            // 현재 문자열이 괄호의 시작 부분일 경우(선언한 map에 해당 문자열의 키가 존재하는 경우)
            if (opener.containsKey(str.charAt(i))) {
                // 스택에 해당 문자열 삽입
                stack.push(str.charAt(i));
                // 현재 문자열이 괄호의 마지막 부분이고, 스택이 비어있지 않은 경우
                // 스택이 비어 있다면, 괄호가 열리기 전에 괄호의 뒷부분이 온 상황이므로 조건에 추가
            } else if (closer.indexOf(str.charAt(i)) != -1 && stack.size() > 0) {
                // 스택에서 꺼낸 값과, 해당 키와 매칭되는 값을 찾아 현재 문자열과 비교
                char top = stack.pop();
                char pair = opener.get(top);
                // 비교한 값이 다르면 false 리턴
                if (pair != str.charAt(i)) {
                    return false;
                }
                // 그 외의 경우 (스택이 비어있고, 현재 문자열이 괄호의 뒷 부분인 경우)
            } else {
                return false;
            }
        }
        // 남아있는 스택이 없다면 true 있다면 false
        return stack.size() == 0;
    }
}
