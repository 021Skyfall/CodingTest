import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int resultA = (a1 * b2) + (a2 * b1);
        int resultB = b1 * b2;

        int gcd = gcd(resultA, resultB);
        System.out.println(resultA/gcd + " " + resultB/gcd);
    }
    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x%y);
    }
}