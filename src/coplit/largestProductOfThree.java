package coplit;

//정수를 요소로 갖는 배열을 입력받아 3개의 요소를 곱해 나올 수 있는 최대값을 리턴해야 합니다.

//입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.
//배열의 요소는 음수와 0을 포함하는 정수입니다.
//배열의 길이는 3 이상입니다.

import java.util.Arrays;

public class largestProductOfThree {
    public static void main(String[] args) {
        int output = largestProductOfThree(new int[]{-1, 2, -5, 7});
        System.out.println(output);
    }
    private static int largestProductOfThree(int[] arr) {
        Arrays.sort(arr);
        int product1 = arr[arr.length-1] * arr[arr.length-2] * arr[arr.length-3];
        int product2 = arr[0] * arr[1] * arr[arr.length-1];
        return Math.max(product1, product2);
    }
}
