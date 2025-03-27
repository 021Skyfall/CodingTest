import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(st.nextToken());
            set.add(m);
        }

        set = set.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));

        StringBuilder sb = new StringBuilder();
        for (int i : set) {
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}