package Programmers.lvl1;

import java.util.HashSet;

public class Phoneketmon {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};

        int result = solution(nums);

        // 결과 출력
        System.out.println(result);
    }

    public static int solution(int[] nums) {
        // 포켓몬의 종류를 저장할 HashSet
        HashSet<Integer> uniquePocketmons = new HashSet<>();

        // 주어진 포켓몬 배열에서 포켓몬 종류를 추가
        for (int num : nums) {
            uniquePocketmons.add(num);
        }

        // 최대 선택 가능 포켓몬 수
        int maxSelect = nums.length / 2;

        // 선택할 수 있는 포켓몬의 수는 포켓몬 종류의 수와 최대 선택 가능 수 중 작은 값
        return Math.min(uniquePocketmons.size(), maxSelect);
    }
}
