import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        StringBuilder sb = new StringBuilder();

        while((n = Integer.parseInt(br.readLine())) > 0){
            boolean[] isPrime = new boolean[2 * n + 1];
            isPrime[0] = isPrime[1] = true;
            for (int i = 2; i <= Math.sqrt(2 * n); i++) {
                if (!isPrime[i]) {
                    for (int j = i * i; j <= 2 * n; j += i) {
                        isPrime[j] = true;
                    }
                }
            }

            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (!isPrime[i]) count++;
            }
            sb.append(count).append('\n');
            count = 0;
        }
        System.out.println(sb);
    }
}
