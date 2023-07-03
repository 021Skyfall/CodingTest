package coplit;

//아래와 같이 정의된 ugly numbers 중 n번째 수를 리턴해야 합니다.
//
//ugly number는 2, 3, 5로만 나누어 떨어지는 수이다.
//1은 1번째 ugly number 이다.
//1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, ...

//ugly numbers를 배열에 저장했을 때, n번째 ugly number의 위치는 인덱스 n-1 입니다.

import java.util.ArrayList;

public class uglyNumbers {
    public static void main(String[] args) {
        int result = uglyNumbers(1);
        System.out.println(result); // --> 1

        result = uglyNumbers(3);
        System.out.println(result); // --> 3
    }
    //O(N)
    private static int uglyNumbers(int n) {
        ArrayList<Integer> uglyNumList = new ArrayList<>();
        uglyNumList.add(1);
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;

        for (int i = 0; i < n; i++) {
            // 가장 작은 수인 1에 2,3,5를 곱한 수 중 가장 작은수를 구함
            // 2가 선택되면
            // 2는 가장 작은 수 1에 곱해졌기 때문에
            // 2는 그 다음 작은 수인 2에 곱해지고
            // 3,5는 가장 작은 수에 곱해짐
            int nextMultiOf2 = uglyNumList.get(idx2) * 2;
            int nextMultiOf3 = uglyNumList.get(idx3) * 3;
            int nextMultiOf5 = uglyNumList.get(idx5) * 5;
            int nextUglyNum = Math.min(Math.min(nextMultiOf2, nextMultiOf3), nextMultiOf5);
            uglyNumList.add(nextUglyNum);

            // 같은 수를 중복해서 저장 가능
            // 각각 별도로 조건문 작성
            if (nextUglyNum == nextMultiOf2) idx2++;
            if (nextUglyNum == nextMultiOf3) idx3++;
            if (nextUglyNum == nextMultiOf5) idx5++;
        }
        return uglyNumList.get(n - 1);
    }
}

//나눗셈 연산을 매번 다시 할 필요가 없습니다. ugly number에 2, 3 또는 5를 곱한 수 역시 ugly number 입니다.