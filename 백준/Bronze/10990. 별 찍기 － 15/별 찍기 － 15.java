import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.print(" ".repeat(n - 1) + "*");
        System.out.println();

        for (int i = 0; i < n - 1; i++) {
            System.out.print(" ".repeat(n - 2 - i) + "*");
            System.out.print(" ".repeat(2 * i + 1));
            System.out.println("*");
        }

        scanner.close();
    }
}