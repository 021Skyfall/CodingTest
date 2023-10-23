import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int max = 1000000;

        boolean[] isPrime = new boolean[max + 1];
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        while (t > 0) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i = 2; i <= n/2; i++) {
                int num = n - i;
                if (!isPrime[i] && !isPrime[num]) {
                    count++;
                }
            }
            sb.append(count).append('\n');
            t--;
        }
        System.out.println(sb);
    }
}