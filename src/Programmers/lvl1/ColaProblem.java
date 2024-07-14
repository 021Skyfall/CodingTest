package Programmers.lvl1;

public class ColaProblem {
    public static void main(String[] args) {
        // 테스트 케이스
        System.out.println(solution(2, 1, 20)); // 19
        System.out.println(solution(3, 1, 20)); // 9
        System.out.println(solution(5, 3, 30)); // 24
    }

    public static int solution(int a, int b, int n) {
        int totalCokes = 0;

        while (n >= a) {
            int newCokes = (n / a) * b;
            totalCokes += newCokes;
            n = (n % a) + newCokes;
        }

        return totalCokes;
    }
}
