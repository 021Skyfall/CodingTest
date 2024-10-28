import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum = 0, add = 1;

        for (int i = 0; i < n; i++) {
            int b = scanner.nextInt();
            if (b == 1) {
                sum += add;
                add++;
            } else if (b == 0) {
                add = 1;
            }
        }
        System.out.println(sum);
        scanner.close();
    }
}