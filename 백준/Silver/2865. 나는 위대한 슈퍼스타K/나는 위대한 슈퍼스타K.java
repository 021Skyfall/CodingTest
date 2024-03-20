import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.*;


public class Main {
    static HashMap<Integer, Double> map = new HashMap<>();

    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 참가자 수
        int m = Integer.parseInt(st.nextToken()); // 라운드 수
        int k = Integer.parseInt(st.nextToken()); // 선발 수

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int participant = Integer.parseInt(st.nextToken());
                double score = Double.parseDouble(st.nextToken());

                // 참가자, 점수를 map에 할당
                map.put(participant, compare(participant, score));
            }
        }

        // 값을 기준으로 내림차순 정렬 후 출력을 위해 list에 할당
        List<Map.Entry<Integer, Double>> list = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .collect(Collectors.toList());

        // 출력을 위해 점수 합산
        double result = 0.0;
        for (int i = 0; i < k; i++) {
            result += list.get(i).getValue();
        }

        System.out.printf("%.1f\n", result);
    }

    // 각 참가자의 점수를 비교하기 위한 함수
    public static double compare(int participant, double score) {
        if (!map.containsKey(participant) || map.get(participant) < score) {
            return score;
        } else {
            return map.get(participant);
        }
    }
}