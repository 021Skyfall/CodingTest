package coplit;

import java.util.Arrays;

//정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.
//버블 정렬(bubble sort)은 여러 정렬 알고리즘(삽입 정렬, 퀵 정렬, 병합 정렬, 기수 정렬 등) 중 가장 기본적인 알고리즘입니다.
//
//버블 정렬 알고리즘은 아래와 같습니다.
//
//첫 번째 요소가 두 번째 요소보다 크면, 두 요소의 위치를 바꿉니다. (swap)
//두 번째 요소와 세 번째 요소보다 크면, 두 요소의 위치를 바꿉니다. (swap)
//1, 2를 마지막까지 반복합니다. (마지막에서 두 번째 요소와 마지막 요소를 비교)
//1~3의 과정을 한 번 거치게 되면, 가장 큰 요소가 배열의 마지막으로 밀려납니다.
//1~3의 과정을 첫 요소부터 다시 반복합니다.
//5를 통해 두 번째로 큰 요소가 배열의 마지막 바로 두 번째로 밀려납니다.
//1~3의 과정을 총 n번(배열의 크기) 반복합니다.
//이 모습이 마치 '거품이 밀려 올라가는 것과 같은 모습'과 같아서 bubble sort라고 부릅니다.

//위에서 설명한 알고리즘을 구현해야 합니다.
//arr.sort 사용은 금지됩니다.
//입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.

public class bubbleSort {
    public static void main(String[] args) {
        int[] output = bubbleSort1(new int[]{2, 1, 3});
        System.out.println(Arrays.toString(output)); // --> [1, 2, 3]
    }
    private static int[] bubbleSort1(int[] arr) {
        // 전달인자 배열 길이 만큼 반복
        for (int i = 0; i < arr.length; i++) {
            // 정렬할 요소 체크
            int swaps = 0;
            // 반복 비교 체크
            // 가장 처음 요소부터 마지막까지 반복
            for (int j = 0; j < arr.length-1; j++) {
                // 이전 요소가 다음 요소보다 크다면 뒤로
                if (arr[j] > arr[j+1]) {
                    // 정렬 체크
                    swaps++;
                    // 새로운 함수 구현해서 배열 위치 조정
                    arr = swap(j,j+1,arr);
                }
            }
            // 정렬할게 없으면
            if (swaps == 0) {
                break;
            }
        }
        return arr;
    }
    private static int[] swap(int idx1, int idx2, int[] arr) {
        //앞의 요소가 뒤로 가야함
        //큰 수를 저장
        int temp = arr[idx1];
        //다음 인덱스에 있던 작은 수를 큰 수가 있던 인덱스 자리로 교체
        arr[idx1] = arr[idx2];
        //큰 수는 다음 인덱스 자리로
        arr[idx2] = temp;
        return arr;
    }
}
