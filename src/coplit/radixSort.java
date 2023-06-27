package coplit;

//정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

//기수 정렬을 구현해야 합니다.
//Arrays.sort 사용은 금지됩니다.
//입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.

import java.util.Arrays;

public class radixSort {
    public static void main(String[] args) {
        int[] output = radixSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]
    }
    private static int[] radixSort(int[] arr) {
        // 순회 -> 배열의 최대값 구함
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxValue < arr[i]) maxValue = arr[i];
        }
        // sort 메서드를 정의 후 사용, 자릿수 기준으로 정렬
        for (int digit = 1; digit <= maxValue; digit *= 10) {
            arr = sort(arr,digit);
        }
        return arr;
    }
    private static int[] sort(int[] arr, int digit) {
        int[] temp = new int[arr.length]; // 임시 배열
        int[] counting = new int[10]; // 카운팅 배열

        for (int i = 0; i < arr.length; i++) {
            // 해당 자리의 숫자 추출
            int num = (arr[i] / digit) & 10;
            counting[num]++;
        }

        // 누적된 합을 배열로
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        // 배열의 가장 마지막 인덱스부터 시작,
        // 가장 큰 수가 뒤로 정렬되어야 하기 때문에
        // 안정적인 정렬을 위해 마지막 요소부터 순회
        for (int i = arr.length - 1; i >= 0; i--) {
            // 현재 배열의 자리
            int num = (arr[i] / digit) % 10;
            // 해당 자릿수를 인덱스로 counting 배열의 요소를 1씩 뺀 후,
            counting[num]--;
            // 구한 값을 인덱스로 배열의 요소 삽입
            temp[counting[num]] = arr[i];
        }
        return temp;
    }
}
