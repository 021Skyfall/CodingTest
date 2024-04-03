import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        List<Double> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Double.parseDouble(st.nextToken()));
        }

        Collections.sort(list);

        int count = 0; // 테이프 수
        double cover = 0; // 테이프로 덮을 수 있는 최대 위치
        for (int i = 0; i < n; i++) {
            // 현재 위치가 이미 덮인 범위를 벗어난 경우에만 테이프 추가
            if (list.get(i) > cover) {
                count++;
                // 테이프로 덮을 수 있는 최대 위치 업데이트
                cover = list.get(i) + l - 1 + 0.5;
            }
        }

        System.out.println(count);
    }
}