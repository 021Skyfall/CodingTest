import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        // 기본 100분, 기본 10원 / 단위 50분, 단위 3원
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = Arrays.stream(st.nextToken().split(":")).mapToInt(Integer::parseInt).toArray();
            String name = st.nextToken();
            int time = ( arr[0] * 60 ) + arr[1];

            map.put(name, map.getOrDefault(name, 0) + time);
        }

        // TreeMap 활용 결과 + 정렬
        TreeMap<String, Integer> result = new TreeMap<>();
        for (String s : map.keySet()) {
            int resultTime = (int) Math.ceil((double) (map.get(s) - 100) / 50) * 3;
            if (resultTime < 0) {
                result.put(s, 10);
            } else {
                result.put(s, 10 + (resultTime));
            }
        }

        result.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}