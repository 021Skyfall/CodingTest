import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(input[i]);
            if (((i + 1) % 2) != (num % 2)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}