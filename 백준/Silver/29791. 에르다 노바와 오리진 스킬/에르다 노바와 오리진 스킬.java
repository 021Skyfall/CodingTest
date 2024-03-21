import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 에르다 사용 횟수
        int m = Integer.parseInt(st.nextToken()); // 오리진 사용 횟수

        int[] erda = new int[n];
        int[] origin = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            erda[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(erda);
        Arrays.sort(origin);

        // 스킬 적용 횟수 계산
        int erdaCount = calculate(erda, 100, 90);
        int originCount = calculate(origin, 360, 90);

        System.out.println(erdaCount + " " + originCount);
    }

    public static int calculate(int[] times, int cooldown, int immunity) {
        int count = 1;
        int lastApplied = times[0]; // 초기값 설정, 스킬이 적용될 수 있는 가장 이른 시간

        for (int i = 1; i < times.length; i++) { // 첫 번째 스킬은 이미 적용되었으므로 i = 1부터 시작
            if (times[i] - lastApplied >= cooldown) {
                count++;
                lastApplied = times[i]; // 스킬 적용 시간 업데이트
            }
        }

        return count;
    }
}