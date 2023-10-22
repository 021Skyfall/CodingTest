import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[n + 1];
        isPrime[0] = isPrime[1] = true;

        for(int i=2; i <= Math.sqrt(n); i++){
            if(!isPrime[i]) {
                for(int j = i * i; j <= n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (!isPrime[i]) sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
}