package coplit;

//정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

//삽입 정렬을 구현해야 합니다.
//Arrays.sort() 사용은 금지됩니다.
//입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] output = insertionSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]
    }
    private static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];
            int j = i - 1;
            while (j >= 0 && target < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = target;
        }
        return arr;
    }
}
