import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i=2; i*i<=n; i++){
            if(isPrime[i]){
                for(int j=i*i; j<=n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (isPrime[i]) sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
}