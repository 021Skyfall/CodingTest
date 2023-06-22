package coplit;

//두 개의 배열(base, sample)을 입력받아 sample이 base의 부분집합인지 여부를 리턴해야 합니다.

//base, sample 내에 중복되는 요소는 없다고 가정합니다.

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class isSubsetOf {
    public static void main(String[] args) {
        int[] base = new int[]{1, 2, 3, 4, 5};
        int[] sample = new int[]{1, 3};

        long start1 = System.nanoTime();
        boolean output1 = isSubsetOf(base, sample);
        long end1 = System.nanoTime();
        System.out.println(output1); // --> true
        System.out.println(end1 - start1 + " ns");

        System.out.println();

        long start2 = System.nanoTime();
        boolean output2 = isSubsetOf2(base, sample);
        long end2 = System.nanoTime();
        System.out.println(output2);
        System.out.println(end2 - start2 + " ns");
    }
    public static boolean isSubsetOf(int[] base, int[] sample) {
        List<Integer> list = Arrays.stream(base).boxed().collect(Collectors.toList());
        for (int i : sample) {
            if (list.contains(i)) return true;
        }
        return false;
    }

    public static boolean isSubsetOf2(int[] base, int[] sample) {
        //O(N^2)
        base = Arrays.stream(base).sorted().toArray();
        sample = Arrays.stream(sample).sorted().toArray();
        int count = 0;
        for (int i = 0; i < base.length; i++) {
            for (int j = 0; j < sample.length; j++) {
                if (base[i] == sample[j]) count++;
            }
        }
        if (count == sample.length) return true;
        return false;
    }
}
