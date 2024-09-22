import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a == 0 && b == 0) {
                break;
            }

            System.out.printf("%d %d / %d%n", a / b, a % b, b);
        }

        scanner.close();
    }
}