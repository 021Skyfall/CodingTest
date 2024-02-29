import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n1 = Integer.parseInt(br.readLine());
            int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Map<Integer, Boolean> map = new HashMap<>();
            for (int num : arr1) {
                map.put(num, true);
            }

            int n2 = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n2; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (map.containsKey(num)) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
            if (sb.charAt(sb.length()-1) == '\n') {
                sb.deleteCharAt(sb.length()-1);
            }

            System.out.println(sb);
        }
    }
}