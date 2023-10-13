import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> li = new HashSet<>();
        for (int i = 0 ; i < n; i++) {
            String name = br.readLine();
            li.add(name);
        }

        TreeSet<String> result = new TreeSet<>();
        for (int i = 0 ; i < m; i++) {
            String name = br.readLine();
            if (li.contains(name)) {
                result.add(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');
        for (String str : result) {
            sb.append(str).append('\n');
        }
        System.out.println(sb);
    }
}