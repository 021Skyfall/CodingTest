import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        while (n-- > 0) {
            char[] grim;
            String input = scanner.nextLine();
            grim = input.toCharArray();

            for (int i = 0; i < m; i++) {
                if (Character.isLetter(grim[i])) {
                    grim[m - i - 1] = grim[i];
                }
            }

            System.out.println(grim);
        }

        scanner.close();
    }
}