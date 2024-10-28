import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long result = (long) n * (n - 1) * (n - 2) * (n - 3) / 24;
        System.out.println(result);
    }
}