import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            String word = br.readLine();

            if (word.length() < m)
                continue;

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 정렬을 위해 엔트리를 리스트로 변환
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());

        // 정렬 조건 적용 (Comparator 구현 with Lambda)
        Collections.sort(entries, (e1, e2) -> {
            // 빈도수에 따라 내림차순 정렬
            int frequency = e2.getValue().compareTo(e1.getValue());
            if (frequency != 0) return frequency;

            // 길이에 따라 내림차순 정렬
            int length = Integer.compare(e2.getKey().length(), e1.getKey().length());
            if (length != 0) return length;

            // 알파벳 순으로 오름차순 정렬
            return e1.getKey().compareTo(e2.getKey());
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : entries) {
            sb.append(entry.getKey()).append('\n');
        }

        System.out.println(sb.toString().trim());
    }
}