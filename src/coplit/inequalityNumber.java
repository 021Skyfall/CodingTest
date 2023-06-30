package coplit;

//아래와 같은 과정을 거쳐 부등호 수(inequalityNumber)를 만들 수 있습니다.
//
//최대 9개의 부등호(<, >)가 주어집니다.
//부등호의 좌우에는 0부터 9사이의 숫자가 한 번씩만 들어가야 합니다.
//부등호를 만족하는 숫자의 조합을 차례대로 이어 붙여 만든 정수를 부등호 수라고 한다.
//부등호 기호들을 입력받아 부등호를 만족하는 최대 부등호 수와 최소 부등호 수의 차이를 리턴해야 합니다.

//첫 자리가 0인 경우도 부등호 수에 포함되어야 합니다.
//모든 입력에 답은 항상 존재합니다.

import java.util.Arrays;

public class inequalityNumber {
    public static void main(String[] args) {
        long output = inequalityNumber("<");
        System.out.println(output); // --> 88 (89 - 01)

        output = inequalityNumber("<,>");
        System.out.println(output); // --> 876 (897 - 021)

        output = inequalityNumber(">,<,>");
        System.out.println(output); // --> 8,754 (9,786 - 1,032)
    }
    private static long inequalityNumber(String signs) {
        String[] arr = signs.split(",");
        int[] digits = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] reverseDigits = new int[]{9,8,7,6,5,4,3,2,1,0};
        long min = aux(-1, arr, new String[]{}, digits, new boolean[10]);
        long max = aux(-1, arr, new String[]{}, reverseDigits, new boolean[10]);
        return max - min;
    }
    private static long aux(int idx, String[] signs, String[] nums, int[] digits, boolean[] isVisited) {
        if (idx == signs.length) {
            // 부등호 수를 만든 경우
            String result = String.join("", nums);
            return Long.parseLong(result);
        }

        String sign;

        if (idx != -1) {
            sign = signs[idx];
        } else {
            sign = "NULL";
        }

        for (int i = 0; i < digits.length; i++) {
            // 숫자를 차례대로 검토
            // max를 구할 때는 9부터, min은 0부터
            int right = digits[i];
            // 이전 단계에서 사용한 숫자인 경우는 패스
            if (isVisited[right]) continue;

            // 첫번째 숫자가 아닌 경우에는 조건이 중요함
            if (idx >= 0) {
                // 항상 바로 직전의 숫자와 비교
                int left = Integer.parseInt(nums[nums.length - 1]);
                if (sign.equals("<") && left >= right) continue;
                if (sign.equals(">") && left <= right) continue;
            }

            // 조건을 만족하거나 첫번째 숫자인 경우
            isVisited[right] = true;
            String[] stringArr = Arrays.copyOf(nums, nums.length + 1);
            stringArr[stringArr.length - 1] = String.valueOf(right);
            long target = aux(idx + 1, signs, stringArr, digits, isVisited);

            if (target != -1) {
                // 부등호 수를 이미 찾은 경우 더 탐색할 필요가 없음
                return target;
            }
            // 탐색에 실패한 경우, 시도한 숫자의 상태를 복구
            isVisited[right] = false;
        }
        return -1;
    }
}
