import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int l = scanner.nextInt();

        int[] fruits = new int[n];
        for (int i = 0; i < n; i++) {
            fruits[i] = scanner.nextInt();
        }

        Arrays.sort(fruits);

        for (int i = 0; i < n; i++) {
            if (fruits[i] <= l) {
                l++;
            } else {
                break;
            }
        }

        System.out.println(l);
    }
}