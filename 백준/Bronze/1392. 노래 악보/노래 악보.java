import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        int[] li = new int[N];
        
        for (int i = 0; i < N; i++) {
            li[i] = scanner.nextInt();
        }
        
        for (int j = 0; j < Q; j++) {
            int t = scanner.nextInt();
            int sum = 0;
            int index = -1;
            
            for (int i = 0; i < N; i++) {
                sum += li[i];
                if (t < sum) {
                    index = i + 1;
                    break;
                }
            }
            
            System.out.println(index);
        }
        
        scanner.close();
    }
}