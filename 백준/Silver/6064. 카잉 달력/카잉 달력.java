import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int result = -1;
            int max = lcm(m, n);

            for (int j = x; j <= max; j += m) {
                int ny = j % n; // y값
                if (ny == 0) // 이때는 y가 최대값이 됨
                    ny = n;

                if (ny == y) {
                    result = j;
                    break;
                }
            }
            System.out.println(result);
        }
    }

    // 최대 공약수
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // 최소 공배수
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}