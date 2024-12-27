import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        List<int[]> shortcuts = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int cost = scanner.nextInt();
            shortcuts.add(new int[]{start, end, cost});
        }
        
        Collections.sort(shortcuts, Comparator.comparingInt(a -> a[0]));
        
        int[] dp = new int[d + 1];
        for (int i = 1; i <= d; i++) {
            dp[i] = i;
        }
        
        int k = 0;
        for (int i = 0; i <= d; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
            }
            
            while (k < n) {
                if (i == shortcuts.get(k)[0]) {
                    int end = shortcuts.get(k)[1];
                    int cost = shortcuts.get(k)[2];
                    if (end <= d) {
                        dp[end] = Math.min(dp[i] + cost, dp[end]);
                    }
                    k++;
                } else {
                    break;
                }
            }
        }
        
        System.out.println(dp[d]);
        scanner.close();
    }
}