import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long N = scanner.nextLong();
        long startIdx = 1, endIdx = 1, sum = 1;
        int cnt = 0;
        
        while (endIdx < N + 1) {
            if (sum < N) {
                endIdx++;
                sum += endIdx;
            } else if (sum > N) {
                sum -= startIdx;
                startIdx++;
            } else if (sum == N) {
                cnt++;
                endIdx++;
                sum += endIdx;
            }
        }
        
        System.out.println(cnt);
        scanner.close();
    }
}