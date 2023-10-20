import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int gcd = arr[1] - arr[0];

        for (int i = 2; i < n; i++) {
            gcd = gcd(gcd, arr[i] - arr[i-1]);
        }

        int count = 0;
        for (int i = 1; i < n; i++) {
            count += ((arr[i] - arr[i-1])/gcd) - 1;
        }

        System.out.println(count);
    }
    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x%y);
    }
}