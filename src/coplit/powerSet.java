package coplit;

// 하나의 집합을 의미하는 문자열을 입력받아 각 문자를 가지고 만들 수 있는 모든 부분집합을 리턴해야 합니다.

// ArrayList의 요소는 각 부분집합을 구성하는 원소를 연결한 문자열입니다.
//ArrayList의 요소는 알파벳 순서로 정렬되어야 합니다.
//집합은 중복된 원소를 허용하지 않습니다.
//부분집합은 빈 문자열을 포함합니다.
//ArrayList는 오름차순으로 정렬되어야 합니다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class powerSet {
    public static void main(String[] args) {
        ArrayList<String> output2 = powerSet("jjump");
        System.out.println(output2); // ["", "j", "jm", "jmp", "jmpu", "jmu", "jp", "jpu", "ju", "m", "mp", "mpu", "mu", "p", "pu", "u"]
    }
    private static ArrayList<String> powerSet(String str) {
        String dedup = dedup(str);
        Stack<String> stack = new Stack<>();

        ArrayList<String> result = new ArrayList<>();
        result = pickOrNot(stack, 0, dedup, result);

        // 오름차순 정렬
        Collections.sort(result);
        return result;
    }
    private static String dedup(String str) {
        String result = "";
        // 중복 여부 확인
        for (int index = 0; index < str.length(); index++) {
            if (str.indexOf(str.charAt(index)) == index) {
                result += str.charAt(index);
            }
        }
        // 정렬 후 중복 제거된 결과 재결합
        String[] sorted = result.split("");
        Arrays.sort(sorted);
        result = String.join(",", sorted).replaceAll(",", "");
        return result;
    }
    // 조합은 검사하기 위한 재귀함수
    private static ArrayList<String> pickOrNot(Stack<String> stack, int idx, String subset, ArrayList<String> result) {
        // base case
        if (idx >= subset.length()) {
            // idx와 subset 길이 비교 후 스택을 문자열로 변환, 잘라서 result에 삽입
            result.add(stack.toString()
                    .replaceAll("\\[","")
                    .replaceAll("]","")
                    .replaceAll(",","")
                    .replaceAll(" ",""));
            return result;
        } else {
            //idx가 부분 집합에 포함된 경우
            stack.push(Character.toString(subset.charAt(idx)));
            pickOrNot(stack, idx+1, subset, result);
            //idx가 부분 집합에 포함되지 않은 경우
            stack.pop();
            pickOrNot(stack, idx+1, subset, result);
        }
        return result;
    }
}
