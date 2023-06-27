package coplit;

//정수를 요소로 갖는 배열을 입력받아 오름차순으로 정렬하여 리턴해야 합니다.

//힙 정렬을 구현해야 합니다.
//Arrays.sort 사용은 금지됩니다.
//입력으로 주어진 배열은 중첩되지 않은 1차원 배열입니다.
//최소 힙(min heap)을 구현해야 합니다.
//Java에서는 쉽게 heap을 사용할 수 있습니다.
//PriorityQueue<Integer> heap = new PriorityQueue<Integer>()와 같은 방식으로 사용할 수 있습니다.

import java.util.Arrays;
import java.util.PriorityQueue;

public class heapSort {
    public static void main(String[] args) {
        int[] output = heapSort(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(output)); // --> [1, 2, 3, 4, 5]

        output = heapSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]

        output = heapSort(new int[]{4, 10, 3, 5, 1});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 4, 5, 10]
    }

    private static int[] heapSort(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll();
        }

        return arr;
    }
}

//앞에서 말했듯이, 최소 힙은 최대 힙과 구현이 거의 일치합니다. 아래 링크를 다시 한번 참고하시기 바랍니다.
//
//https://www.cs.usfca.edu/~galles/visualization/Heap.html
//아래와 같은 최소 힙에서 루트 노드의 값(2)은 전체 노드의 값 중에서 가장 작습니다.
// 루트 노드를 제거한 후에도 최소 힙을 유지해야 하려면 어떤 작업이 필요한 지 고민하시기 바랍니다.
// 2가 제거된 후의 최소 힙의 루트 노드는 2를 제외한 값 중 가장 작은 값(3)이 되어야 합니다.
// 아래와 같은 사실로부터 힙 정렬에 대한 아이디어를 얻길 바랍니다.
//
//루트 노드를 제거하고(가장 작은 값을 제거하고) 다시 최소 힙을 유지하면, 새로운 루트 노드의 값은 그 다음으로 가장 작은 값이다.