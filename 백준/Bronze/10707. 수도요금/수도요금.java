import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int p = scanner.nextInt();
        
        int x = a * p;
        int y;
        
        if (c < p) {
            y = b + ((p - c) * d);
        } else {
            y = b;
        }
        
        System.out.println(Math.min(x, y));
        
        scanner.close();
    }
}