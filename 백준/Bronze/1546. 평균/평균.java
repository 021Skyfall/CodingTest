import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = 0;
        double sum = 0;

        for (int i = 0; i < total; i++) {
            int score = Integer.parseInt(st.nextToken());
            if (score > m) {
                m = score;
            }
            sum += score;
        }

        System.out.println(sum / m * 100 / total);
    }
}