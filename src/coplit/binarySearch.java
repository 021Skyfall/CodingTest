package coplit;

//오름차순 정렬된 정수의 배열(arr)과 정수(target)를 입력받아 target의 인덱스를 리턴해야 합니다.

//이진탐색 알고리즘(O(logN))을 사용해야 합니다.
//단순한 배열 순회(O(N))로는 통과할 수 없는 테스트 케이스가 존재합니다.
//target이 없는 경우, -1을 리턴해야 합니다.

public class binarySearch {
    public static void main(String[] args) {
        int output = binarySearch(new int[]{0, 1, 2, 3, 4, 5, 6}, 2);
        System.out.println(output); // --> 2

        output = binarySearch(new int[]{4, 5, 6, 9}, 100);
        System.out.println(output); // --> -1
    }

    private static int binarySearch(int[] arr, int target) {
        // 좌
        int min = 0;
        // 우
        int max = arr.length - 1;

        // 탐색
        // 좌, 우가 같아지면 종료
        while (min <= max) {
            // 이진 탐색을 위한 중간 인덱스
            int mid = (min + max) / 2;
            // 검증 시작
            if (arr[mid] == target) return mid;
            // 오름차순 정렬되어 있으므로
            // 가운데의 요소가 타겟 보다 크다면 우측 -1
            if (target < arr[mid]) {
                max = mid - 1;
            } else { // 가운데 요소가 타겟보다 작다면 좌측 + 1
                min = mid + 1;
            }
        }
        return -1;
    }
}
