package coplit;


import java.util.Arrays;
import java.util.stream.IntStream;

//길이가 m, n이고 오름차순으로 정렬되어 있는 자연수 배열들을 입력받아 전체 요소 중 k번째 요소를 리턴해야 합니다.

//두 배열의 길이의 합은 1,000,000 이하입니다.
//어떤 배열 arr의 k번째 요소는 arr[k-1]을 의미합니다.

public class getItemFromTwoSortedArrays {
    public static void main(String[] args) {
        long start1 = System.nanoTime();
        int[] arr1 = new int[]{1, 4, 8, 10};
        int[] arr2 = new int[]{2, 3, 5, 9};
        int result = getItemFromTwoSortedArrays(arr1, arr2, 6);
        System.out.println(result); // --> 8

        arr1 = new int[]{1, 1, 2, 10};
        arr2 = new int[]{3, 3};
        result = getItemFromTwoSortedArrays(arr1, arr2, 4);
        System.out.println(result); // --> 3
        long end1 = System.nanoTime();
        System.out.println(end1 - start1 + " ns");

        long start2 = System.nanoTime();
        int[] arr3 = new int[]{1, 4, 8, 10};
        int[] arr4 = new int[]{2, 3, 5, 9};
        int result2 = getItemFromTwoSortedArrays2(arr3, arr4, 6);
        System.out.println(result2); // --> 8
        arr3 = new int[]{1, 1, 2, 10};
        arr4 = new int[]{3, 3};
        result2 = getItemFromTwoSortedArrays2(arr3, arr4, 4);
        System.out.println(result2); // --> 3
        long end2 = System.nanoTime();
        System.out.println(end2 - start2 + " ns");
    }
    // O(N)
    private static int getItemFromTwoSortedArrays(int[] arr1, int[] arr2, int k) {
        int[] arr = IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).toArray();
        arr = Arrays.stream(arr).sorted().toArray();

        return arr[k-1];
    }
    // O(logN)
    private static int getItemFromTwoSortedArrays2(int[] arr1, int[] arr2, int k) {
        int leftIdx = 0;
        int rightIdx = 0;
        while (k > 0) {
            // 이진 탐색을 위해 각 배열에서 k를 절반으로 쪼갠 후 카운트
            int cnt = (int)Math.ceil(((double) k) / 2);
            int leftStep = cnt;
            int rightStep = cnt;

            // 엣지 케이스
            // 카운트가 남아있음에도 배열의 끝에 도달하게되면 k를 나머지 배열 쪽으로 넘김
            if (leftIdx == arr1.length) {
                rightIdx += k;
                break;
            }
            if (rightIdx == arr2.length) {
                leftIdx += k;
                break;
            }

            // 엣지 케이스
            // 현재 카운트가 남아있는 후보 요소들보다 많을 경우, leftStep(현재 할당량)을 남아있는 요소들의 개수로 바꿈
            if (cnt > arr1.length - leftIdx) leftStep = arr1.length - leftIdx;
            if (cnt > arr2.length - rightIdx) rightStep = arr2.length - rightIdx;

            // 두 배열의 현재 검사 요소 위치를 비교하고, 그 값이 작은 배열은 삐교한 위치 앞에 있는 요소들을 모두 후보군에서 제외
            if (arr1[leftIdx + leftStep - 1] < arr2[rightIdx + rightStep - 1]) {
                leftIdx = leftIdx + leftStep;
                // 처리가 끝나면 K값을 절반으로 줄임
                k -= leftStep;
            } else {
                rightIdx = rightIdx + rightStep;
                k -= rightStep;
            }
        }
        int leftMax = (leftIdx - 1 < arr1.length) ? arr1[leftIdx - 1] : -1;
        int rightMax = (rightIdx - 1 < arr2.length) ? arr2[rightIdx - 1]  : -1;

        return Math.max(leftMax, rightMax);
    }
}
