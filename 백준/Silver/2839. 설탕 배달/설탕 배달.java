import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max = n / 5;
        int min = Integer.MAX_VALUE;

        for (int i = max; i >= 0; i--) {
            int remain = n - i * 5;
            if (remain % 3 == 0) {
                int bags = i + remain / 3;
                min = Math.min(min, bags);
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}