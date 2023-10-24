import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            count++;
        }
        
        System.out.println(count);
    }
}