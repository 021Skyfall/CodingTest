import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String now = br.readLine();
        String[] time = now.split(" ");
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        int timer = Integer.parseInt(br.readLine());

        h = (h+ (m+timer) / 60) % 24;
        m = (m+timer)%60;
        System.out.println(h + " " + m);
    }
}