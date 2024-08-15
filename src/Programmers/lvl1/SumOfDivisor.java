package Programmers.lvl1;

public class SumOfDivisor {
    public static void main(String[] args) {
        System.out.println(solution(12));
    }

    public static int solution(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
