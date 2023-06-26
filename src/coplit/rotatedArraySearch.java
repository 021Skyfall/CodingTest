package coplit;

//부분적으로 오름차순 정렬*된 정수의 배열(rotated)과 정수(target)를 입력받아 target의 인덱스를 리턴해야 합니다.
//
//부분적으로 정렬된 배열: 배열을 왼쪽 혹은 오른쪽으로 0칸 이상 순환 이동할 경우 완전히 정렬되는 배열
//예시: [4, 5, 6, 0, 1, 2, 3]은 왼쪽으로 3칸 또는 오른쪽으로 4칸 순환 이동할 경우 완전히 정렬됩니다.

//rotated에 중복된 요소는 없습니다.
//target이 없는 경우, -1을 리턴해야 합니다.

public class rotatedArraySearch {
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 2)); // --> 5
        long end = System.nanoTime();
        System.out.println(end - start + " ns");
        System.out.println();

        long start1 = System.nanoTime();
        System.out.println(rotatedArraySearch2(new int[]{4, 5, 6, 0, 1, 2, 3}, 2)); // --> 5
        long end1 = System.nanoTime();
        System.out.println(end1 - start1 + " ns");
    }
    // O(N)
    private static int rotatedArraySearch(int[] rotated, int target) {
        for (int i = 0; i < rotated.length; i++) {
            int x = rotated[i];
            if (x == target) return i;
        }
        return -1;
    }
    // O(logN)
    private static int rotatedArraySearch2(int[] rotated, int target) {
        int left = 0;
        int right = rotated.length - 1;

        while (left <= right) {
            int middle = (right + left) / 2;

            if (rotated[middle] == target) {
                return middle;
            }

            if (rotated[left] < rotated[middle]) {
                // 왼쪽 절반이 정렬되어있는 상태
                if (target < rotated[middle] && rotated[left] <= target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                // 오른쪽 절반이 정렬되어 있는 상태
                if (target <= rotated[right] && rotated[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
