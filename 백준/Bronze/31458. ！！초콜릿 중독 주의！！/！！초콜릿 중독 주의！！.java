import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        sc.nextLine(); 

        while (N-- > 0) {
            String s = sc.nextLine();
            long idx = 0;

            for (int i = 0; ; i++) {
                if (s.charAt(i) != '!') {
                    idx = i;
                    break;
                }
            }

            boolean result = !((idx % 2 == 0) == (s.charAt(s.length() - 1) == '0'));
            System.out.println(result ? 1 : 0);
        }

        sc.close();
    }
}