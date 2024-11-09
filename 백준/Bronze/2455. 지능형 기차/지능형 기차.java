import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] on = new int[4];
        int people = 0;

        for (int i = 0; i < 4; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            people += b;
            people -= a;
            on[i] = people;
        }

        int maxPeople = on[0];
        for (int i = 1; i < on.length; i++) {
            if (on[i] > maxPeople) {
                maxPeople = on[i];
            }
        }

        System.out.println(maxPeople);
        scanner.close();
    }
}