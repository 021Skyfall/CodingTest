import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("* ".repeat(n - n / 2));
            System.out.println();
            System.out.print(" *".repeat(n / 2));
            System.out.println();
        }
        
        scanner.close();
    }
}