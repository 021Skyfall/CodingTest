package Programmers.lvl1;

public class WeaponOfSoldier {
    public static void main(String[] args) {
        int number = 5; // 기사단원의 수
        int limit = 3;  // 제한
        int power = 2;  // 초과 시 공격력

        int result = solution(number, limit, power);

        // 결과 출력
        System.out.println(result); // 최대 공격력 출력
    }

    public static int solution(int number, int limit, int power) {
        int totalAttackPower = 0;

        for (int i = 1; i <= number; i++) {
            int attackPower = calculateAttackPower(i, limit, power);
            totalAttackPower += attackPower;
        }

        return totalAttackPower;
    }

    private static int calculateAttackPower(int n, int limit, int power) {
        int divisorCount = countDivisors(n);

        if (divisorCount > limit) {
            return power; // 제한을 초과하면 power 반환
        } else {
            return divisorCount; // 제한 이내이면 약수의 개수 반환
        }
    }

    private static int countDivisors(int n) {
        int count = 0;

        // n의 약수를 세기
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++; // 약수 i
                if (i != n / i) {
                    count++; // n / i가 다른 약수일 경우
                }
            }
        }

        return count;
    }
}
