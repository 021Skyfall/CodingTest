import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> list = new HashSet<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        int count = 0;
        for (int i = 0 ; i < m; i++) {
            if (list.contains(br.readLine()))
                count++;
        }
        System.out.println(count);
    }
}