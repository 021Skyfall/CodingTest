import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            if (st.nextToken().equals("leave")) {
                result.remove(name);
            } else {
                result.put(name,null);
            }
        }

        ArrayList<String> listKeys = new ArrayList<>(result.keySet());
        Collections.sort(listKeys);
        Collections.reverse(listKeys);

        StringBuilder sb = new StringBuilder();
        for (String str : listKeys) {
            sb.append(str).append('\n');
        }
        System.out.println(sb);
    }
}