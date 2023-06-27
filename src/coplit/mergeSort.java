package coplit;

import java.util.Arrays;

// 정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

//병합 정렬을 구현해야 합니다.
//Arrays.sort 사용은 금지됩니다.
//입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.

public class mergeSort {
    public static void main(String[] args) {
        int[] output = mergeSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]
    }
    private static int[] mergeSort(int[] arr) {
        sort(arr, 0, arr.length-1);
        return arr;
    }
    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            // 중간 idx
            int mid = (left + right) / 2;
            // 중간 idx를 기준으로 나눔
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            // 정렬, 병합
            merge(arr, left, right, mid);
        }
    }
    private static void merge(int[] arr, int left, int right, int mid) {
        // 임시 배열에 기존 배열 복사
        int[] sorted = Arrays.copyOfRange(arr, 0, arr.length);
        // left idx
        int l = left;
        // right idx
        int r = mid + 1;
        // 정렬된 값을 병합된 배열에 넣을 인덱스
        int idx = left;

        // 좌측 배열, 우측 배열 중 하나의 요소가 전부 없어질 때까지 반복
        while(l <= mid && r <= right) {
            if (sorted[l] <= sorted[r]) {
                arr[idx++] = sorted[l++];
            } else {
                arr[idx++] = sorted[r++];
            }
        }
        // 좌측 배열에 요소가 남았을 경우, 남은 요소를 삽입
        for (int i = 0; i <= mid - l; i++) {
            arr[idx+i] = sorted[l+i];
        }
    }
}

//병합 정렬은 표준 라이브러리에서 정렬을 구현할 때 퀵 정렬이나 힙 정렬의 대안으로 사용하는 최적화된 정렬 알고리즘입니다.
// 병합 정렬은 다음과 같은 알고리즘을 사용합니다.
//
//N의 길이를 가진 배열 리스트를 1의 길이를 가진 "부분 리스트"가 N개 모인 것으로 취급합니다.
//인접한 부분 리스트들을 정렬하여 2의 길이를 가진 부분 리스트로 병합합니다.
//2의 길이를 가진 인접한 부분 리스트들을 4의 길이를 가진 부분 리스트로 합칩니다.
//하나의 정렬된 리스트가 될 때까지 위 과정을 반복합니다.
//N이 홀수라면, 첫 번째 병합 때 1의 길이를 가진 부분 리스트를 남깁니다.
//병합 정렬은 두 가지 방식으로 구현 가능합니다. 재귀적 접근(위->아래) 그리고 반복적 접근(아래->위)