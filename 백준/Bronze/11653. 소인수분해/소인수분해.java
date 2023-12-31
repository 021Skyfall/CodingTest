import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = 2;

        while(k * k <= n) {
            if (n % k == 0) {
                System.out.println(k);
                n /= k;
            } else {
                k++;
            }
        }

        if (n > 1) {
            System.out.println(n);
        }
    }
}