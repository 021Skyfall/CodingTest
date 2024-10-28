import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        int[] stick = {64, 32, 16, 8, 4, 2, 1};
        int count = 0;

        for (int i = 0; i < stick.length; i++) {
            if (x >= stick[i]) {
                count++;
                x -= stick[i];
            }

            if (x == 0) {
                break;
            }
        }

        System.out.println(count);
        scanner.close();
    }
}