package coplit;

//정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

//퀵 정렬을 구현해야 합니다.
//arr.sort 사용은 금지됩니다.
//입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] output = quickSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]
    }
    private static int[] quickSort(int[] arr) {
        if (arr.length == 0) return arr;
        // 좌우 기준 변수
        int left = 0;
        int right = arr.length -1;

        return sort(arr,left,right);
    }
    private static int[] sort(int[] arr, int left, int right) {
        // 정렬
        int part = partition(arr,left,right);
        // 정렬된 결과로 바꿔주면서 재귀호출
        if (left < part - 1) arr = sort(arr,left,part - 1);
        if (right > part) arr = sort(arr, part, right);

        return arr;
    }
    private static int partition(int[] arr, int left, int right) {
        // 배열 중앙 지정 후 디바이드 앤드 컨쿼
        int pivot = arr[(left+right)/2];
        // 좌측이 우측보다 작으면 정렬이 완료되지 않음
        while(left <= right) {
            // 좌측이 기준인 중앙보다 작다면 ++
            while(arr[left] < pivot) left++;
            // 우측이 기준인 중앙보다 크다면 --
            while (arr[right] > pivot) right--;
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
