package coplit;

// 세로 길이 2, 가로 길이 n인 2 x n 보드가 있습니다. 2 x 1 크기의 타일을 가지고 이 보드를 채우는 모든 경우의 수를 리턴해야 합니다.

// 타일을 가로, 세로 어느 방향으로 놓아도 상관없습니다. (입출력 예시 참고)

import java.util.ArrayList;
import java.util.Arrays;

public class tiling {
    public static void main(String[] args) {
        int output = tiling(4);
        System.out.println(output); // --> 5
    }
    private static int tiling(int num) {
        // O(N)
        // 인덱스 관리를 위해 더미로 채움
        ArrayList<Integer> memo = new ArrayList<>(Arrays.asList(0,1,2));
        return aux(num, memo);
    }
    private static int aux(int size, ArrayList<Integer> memo) {
        // 해결된 문제는 넘어감
        if (memo.size() > size) return memo.get(size);

        // 피보나치 수열과 비슷한 로직인데
        // 각각 계산된 리스트를 갖고 경우의 수를 구하기 위함
        memo.add(aux(size - 1 , memo) + aux(size - 2, memo));
        return memo.get(size);
    }
}
