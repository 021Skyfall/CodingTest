import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < T; t++) {
            String A = scanner.nextLine();
            String B = scanner.nextLine();

            int count = 0;

            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    count++;
                }
            }
            System.out.println("Hamming distance is " + count + ".");
        }

        scanner.close();
    }
}