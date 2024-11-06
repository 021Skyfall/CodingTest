import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int a1 = scanner.nextInt();
        int a0 = scanner.nextInt();
        
        int c1 = scanner.nextInt();
        int c2 = scanner.nextInt();
        
        int N = scanner.nextInt();
        
        for (int i = N; i <= 100; i++) {
            if (!(c1 * i <= a1 * i + a0 && a1 * i + a0 <= c2 * i)) {
                System.out.println(0);
                return;
            }
        }
        
        System.out.println(1);
    }
}