import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        String[] names = new String[n+1];

        for (int i = 0; i < n + 1; i++) {
            if (i == 0) continue;
            String name = br.readLine();
            names[i] = name;
            map.put(name, i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String key = br.readLine();
            if (map.containsKey(key)) {
                sb.append(map.get(key)).append('\n');
            } else {
                int idx = Integer.parseInt(key);
                sb.append(names[idx]).append('\n');
            }
        }
        System.out.println(sb);
    }
}