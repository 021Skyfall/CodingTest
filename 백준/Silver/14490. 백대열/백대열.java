import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = br.readLine();
        String[] arr = in.split(":");

        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        int gcd = gcd(n, m);

        System.out.println(n / gcd + ":" + m / gcd);
    }

    private static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}