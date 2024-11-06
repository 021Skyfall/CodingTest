import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < testCases; t++) {
            int cnt = 0;
            String a = scanner.nextLine().replace(" ", "").trim();
            for (char i : a.toCharArray()) {
                cnt += i - 'A' + 1;
            }
            if (cnt == 100) {
                System.out.println("PERFECT LIFE");
            } else {
                System.out.println(cnt);
            }
        }

        scanner.close();
    }
}