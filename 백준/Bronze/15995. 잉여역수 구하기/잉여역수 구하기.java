import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int m = scanner.nextInt();

        int i = 1;
        while (true) {
            long value = 1 + (long) i * m;
            if (value / a == (value + a - 1) / a) { // 조건을 확인
                System.out.println(value / a);
                break;
            }
            i++;
        }

        scanner.close();
    }
}