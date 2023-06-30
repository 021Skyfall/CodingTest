package coplit;

// 다양한 동전들을 가지고 특정 금액을 만들 수 있는 모든 경우의 수를 리턴해야 합니다.
//예를 들어, 100원, 500원짜리 동전을 가지고 1,000원을 만들 수 있는 방법은 총 3가지 입니다.
//100원 10개, 100원 5개 + 500원 1개, 500원 2개

//동전의 금액은 다양하게 주어집니다.
//coins는 오름차순으로 정렬되어 있습니다.
//각 동전의 개수는 무수히 많다고 가정합니다.

import java.util.ArrayList;
import java.util.Arrays;

public class coinChange {
    public static void main(String[] args) {
        int total = 10;
        int[] coins = new int[]{1, 5};
        int output = coinChange(total, coins);
        System.out.println(output); // --> 3

        total = 4;
        coins = new int[]{1, 2, 3};
        output = coinChange(total, coins);
        System.out.println(output); // --> 4 ([1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3])
    }

    // O(M*N)
    // coins.length = M / total = N
    private static int coinChange(int total, int[] coins) {
        // memo.get(i)[j]는 i 만큼의 금액을 coins[j]부터 ~ coins[coins.length - 1]까지 사용하여 만들 수 있는 경우의 수를 저장
        ArrayList<Integer[]> memo = new ArrayList<>();
        for (int i = 0; i < total + 1; i++) {
            Integer[] arr = new Integer[coins.length];
            Arrays.fill(arr, -1);
            memo.add(arr);
        }
        return makeChangeFrom(total, 0, coins, memo);
    }
    private static int makeChangeFrom(int left, int idx, int[] coins, ArrayList<Integer[]> memo) {
        // 0을 만드는 방법은 1가지이다. 아니면 목표 금액을 만들었다고 생각해도됨
        if (left == 0) return 1;
        // 금액이 마이너스가 되는 경우는 불가능하므로 0을 리턴
        if (left < 0) return 0;
        // 동전을 전부 검토해서, 남아있는 새로운 동전은 없는데 목표 금액을 만들지 못한 경우
        if (idx >= coins.length && left > 0) return 0;
        // 이미 해결한 적이 있는 문제는 다시 풀지 않음
        if (memo.get(left)[idx] != -1) return memo.get(left)[idx];

        // left만큼의 금액을 coins[idx]부터 사용하여 만들 수 있는 경우의 수는
        // 1. coins[idx]는 그만 사용하고, 다음 동전으로 넘어가거나 (목표 금액은 그대로이고, idx가 증가한다.)
        // 2. coins[idx]를 한번 더 사용한다. coins[idx]룰 또 사용할 수 있으므로, idx는 그대로이고, 목표 금액은 coins[i]만큼 줄어든다.
        memo.get(left)[idx] = makeChangeFrom(left, idx + 1, coins, memo) + makeChangeFrom(left - coins[idx], idx, coins, memo);
        return memo.get(left)[idx];
    }
}
