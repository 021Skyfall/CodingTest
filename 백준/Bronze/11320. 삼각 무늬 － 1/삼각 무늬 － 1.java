import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double t = scanner.nextDouble();

        while (t-- > 0) {
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            System.out.println((int) Math.ceil((a * a) / (b * b)));
        }

        scanner.close();
    }
}