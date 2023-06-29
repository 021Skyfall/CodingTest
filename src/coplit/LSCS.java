package coplit;

//정수를 요소로 갖는 배열을 입력받아 다음의 조건을 만족하는 LSCS*를 리턴해야 합니다.
//
//LSCS: 주어진 배열의 연속된 부분 배열*의 합을 구한다고 할 때, 이 중 가장 큰 값(Largest Sum of Contiguous Subarray)
//연속된 부분 배열들: 배열 [1,2,3]의 연속 부분 배열은 [1], [1, 2], [1, 2, 3], [2], [2, 3], [3] 입니다.

//배열의 모든 요소가 음수인 경우도 있습니다.

public class LSCS {
    public static void main(String[] args) {
        int output = LSCS(new int[]{1, 2, 3});
        System.out.println(output); // --> 6

        output = LSCS(new int[]{1, 2, 3, -4});
        System.out.println(output); // --> 6 ([1, 2, 3])

        output = LSCS(new int[]{1, 2, 3, -4, 5});
        System.out.println(output); // --> 7 ([1, 2, 3, -4, 5])

        output = LSCS(new int[]{10, -11, 11});
        System.out.println(output); // --> 11 ([11])
    }
    // O(N)
    private static int LSCS(int[] arr) {
        // 연속 배열의 합
        int subArrSum = 0;
        // 정답의 후보 저장, 음수를 포함하기 때문에 사용 가능한 최저 음수를 할당
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        System.out.println(max);
        System.out.println(min);
        for (int i = 0; i < arr.length; i++) {
            subArrSum += arr[i];
            if (subArrSum > max) max = subArrSum;
            // 연속된 구간의 합이 음수인 경우
            // 해당 부분은 버리고 다시 시작
            if (subArrSum < 0) {
                subArrSum = 0;
            }
        }
        return max;
    }
}
