import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 각 숫자 저장
        HashMap<Integer, Integer> map = new HashMap<>();
        // 결과 저장
        List<String> result = new ArrayList<>();

        // 입력된 숫자 저장
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 목표 합계
        int target = Integer.parseInt(br.readLine());

        for (Integer num : map.keySet()) {
            int complement = target - num; // 현재 숫자와 짝을 이룰 수 있는 수
            if ((num == complement && map.get(num) > 1) || (num != complement && map.containsKey(complement))) {
                int min = Math.min(num, complement); // 수 쌍 중 작은 수
                int max = Math.max(num, complement); // 수 쌍 중 큰 수
                String pair = min + " " + max;
                if (!result.contains(pair)) {
                    result.add(pair);
                }
            }
        }

        Collections.sort(result);
        for (String pair : result) {
            System.out.println(pair);
        }
        
        System.out.println(result.size());
        
    }
}