package coplit;

//히스토그램(histogram)은 표(도수 분포표, 빈도표)로 되어 있는 도수 분포(frequency distribution)를 정보 그림으로 나타낸 것입니다.
// 예를 들어, 대학교의 한 학과에서 신입생들의 현재 거주 지역을 조사한 결과가 다음과 같다고 가정해 봅시다.
//
//서울 2명, 경기 1명, 대전 4명, 부산 5명, 대구 1명, 광주 3명, 제주도 3명...
//이 자료를 히스트그램으로 나타내면 각각 높이 2, 1, 4, 5, 1, 3, 3인 직사각형이 왼쪽부터 그려지게 됩니다.
// 편의상 직사각형의 너비는 1이라고 가정합니다. 이를 그림으로 나타내면 아래와 같습니다.
//6 |
//5 |       x
//4 |     x x
//3 |     x x   x x
//2 | x   x x   x x
//1 | x x x x x x x
//------------------
//이 히스토그램 내에서 만들 수 있는 가장 큰 직사각형의 면적은 8입니다 (O로 표시한 부분).
//
//6 |
//5 |       x
//4 |     O O
//3 |     O O   x x
//2 | x   O O   x x
//1 | x x O O x x x
//------------------
//이처럼 임의의 히스토그램 내에서 가장 큰 직사각형의 면적을 리턴해야 합니다.

//Stack을 사용하여 PLE(previous less element), NLE(next less element) 알고리즘을 구현하여 해결합니다.

import java.util.Arrays;
import java.util.Stack;

public class largestRectangularArea {
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] histogram = new int[]{2, 1, 4, 5, 1, 3, 3};
        int output = largestRectangularArea(histogram);
        System.out.println(output); // --> 8

        histogram = new int[]{6, 2, 5, 4, 5, 1, 6};
        output = largestRectangularArea(histogram);
        System.out.println(output); // --> 12
        long end = System.nanoTime();
        System.out.println(end - start + " ns");
/*
6 | x           x
5 | x   x   x   x
4 | x   O O O   x
3 | x   O O O   x
2 | x x O O O   x
1 | x x O O O x x
------------------
*/

        long start1 = System.nanoTime();
        int[] histogram1 = new int[]{2, 1, 4, 5, 1, 3, 3};
        int output1 = largestRectangularArea1(histogram1);
        System.out.println(output1); // --> 8

        histogram1 = new int[]{6, 2, 5, 4, 5, 1, 6};
        output1 = largestRectangularArea1(histogram1);
        System.out.println(output1); // --> 12
        long end1 = System.nanoTime();
        System.out.println(end1 - start1 + " ns");
    }
    // naive solution: O(N^2)
    private static int largestRectangularArea(int[] histogram) {
        int largest = 0;
        // 모든 연속된 부분 히스토그램을 고려함
        // 밑변의 길이를 부분 히스토그램의 길이로 고정하면, 높이는 가장 낮은 막대의 높이가 됨
        for (int left = 0; left < histogram.length; left++) {
            // 길이가 1인 막대로 만들 수 있는 직사각형의 넓이는 막대의 높이와 같음
            int min = histogram[left];
            for (int right = left; right < histogram.length; right++) {
                // left부터 right까지의 히스토그램의 막대 중 가장 낮은 막대의 높이를 구함
                if (histogram[right] < min) min = histogram[right];
                // 해당 구간(left ~ right)의 막대를 전부 포함해서 만들 수 있는 직사각형의 넓이를 구함
                int area = min * (right - left + 1);
                // 매번 구한 면적을 기존의 면적과 비교해 갱신
                if (area > largest) largest = area;
            }
        }
        return largest;
    }
    // naive solution: O(N)
    private static int largestRectangularArea1(int[] histogram) {
        int maxArea = 0;
        int[] tempPle = new int[histogram.length];
        int[] tempNle = new int[histogram.length];
        Arrays.fill(tempPle, -1);
        Arrays.fill(tempNle, -1);

        int[] PLE = findPLE(tempPle, histogram);
        int[] NLE = findNLE(tempNle, histogram);
        for (int i = 0; i < histogram.length; i++) {
            int barsOnLeft = PLE[i] == -1 ? i : i - PLE[i] -1;
            int barsOnRight = NLE[i] == -1 ? histogram.length -1 -i : NLE[i] -1 -i;
            int width = barsOnLeft + barsOnRight + 1;
            maxArea = Math.max(maxArea, width * histogram[i]);
        }
        return maxArea;
    }
    private static int[] findPLE(int[] PLE, int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < histogram.length; i++) {
            while (stack.size() > 0 && histogram[stack.get(stack.size() - 1)] >= histogram[i]) {
                stack.pop();
            }
            if (stack.size() > 0) {
                PLE[i] = stack.get(stack.size() - 1);
            }
            stack.push(i);
        }
        return PLE;
    }
    private static int[] findNLE(int[] NLE, int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        for (int i = histogram.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && histogram[stack.get(stack.size() -1)] >= histogram[i]) {
                stack.pop();
            }
            if (stack.size() > 0) {
                NLE[i] = stack.get(stack.size() - 1);
            }
            stack.push(i);
        }
        return NLE;
    }
}
