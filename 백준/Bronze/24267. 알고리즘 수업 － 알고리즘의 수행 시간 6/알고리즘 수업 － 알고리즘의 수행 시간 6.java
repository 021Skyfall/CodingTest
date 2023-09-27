import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        br.close();
        bw.write((n*(n-1)*(n-2)/6) + "\n" + 3);
        bw.flush();
        bw.close();
    }
}