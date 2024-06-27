package Programmers.lvl2.dynamic;

public class elevator {
    public static void main(String[] args) {
        int storey = 2554;
        int result = solution(storey);
        System.out.println("최소 이동 횟수: " + result);
    }

    private static int solution(int storey) {
        if (storey == 0) {
            return 0;
        }

        int lastDigit = storey % 10;
        int remaining = storey / 10;

        if (lastDigit > 5) {
            return (10 - lastDigit) + solution(remaining + 1);
        } else if (lastDigit == 5) {
            if ((remaining % 10) >= 5) {
                return 5 + solution(remaining + 1);
            } else {
                return 5 + solution(remaining);
            }
        } else {
            return lastDigit + solution(remaining);
        }
    }
}
