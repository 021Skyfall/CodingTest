import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= Math.min(n, m); i++) {
            if (n % i == 0 && m % i == 0) {
                divisors.add(i);
            }
        }

        for (int divisor : divisors) {
            System.out.println(divisor + " " + (n / divisor) + " " + (m / divisor));
        }

        scanner.close();
    }
}