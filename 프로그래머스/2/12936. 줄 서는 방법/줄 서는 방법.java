import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();
        long factorial = 1;

        // 초기 숫자 리스트와 팩토리얼 값 계산
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial *= i;
        }

        // k는 0-based index를 사용하기 위해 1 감소
        k--;

        // 각 자리수 결정
        for (int i = 0; i < n; i++) {
            factorial /= (n - i);
            int index = (int)(k / factorial);
            answer[i] = numbers.get(index);
            numbers.remove(index);
            k %= factorial;
        }

        return answer;
    }
}