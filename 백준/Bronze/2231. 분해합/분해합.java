import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 1; i < n; i++) {
            int sum = sumOf(i);
            if (i + sum == n) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
    private static int sumOf(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10; // 숫자의 각자리 수 더함
            n /= 10; // 다음 자리수로 이동
        }
        return sum;
    }
}