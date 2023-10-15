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

        st = new StringTokenizer(br.readLine());
        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set1.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        HashSet<Integer> set2 = new HashSet<>();

        int unique2 = 0;
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!set1.contains(num)) {
                unique2++;
            }
            set2.add(num);
        }

        int unique1 = 0;
        for (int num : set1) {
            if (!set2.contains(num)) {
                unique1++;
            }
        }

        System.out.println(unique1+unique2);
    }
}