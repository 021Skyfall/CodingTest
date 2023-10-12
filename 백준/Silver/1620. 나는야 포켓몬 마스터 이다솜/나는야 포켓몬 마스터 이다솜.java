import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        // 순서보장 + 중복 X + 해시사용 -> 조회 빠름 + 키와 값 쌍으로 저장
        // 키는 답을 조회하기 위함
        // 문제를 낼 때 키와 값 둘중 하나로 나올 수 있으니 두 개 생성
        // 문제가 자연수일 때
        LinkedHashMap<Integer, String> numList = new LinkedHashMap<>();
        // 문제가 문자열일 때
        LinkedHashMap<String,Integer> strList = new LinkedHashMap<>();

        // n개의 문제
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            numList.put(i, name);
            strList.put(name, i);
        }

        // 답 저장용
        StringBuilder sb = new StringBuilder();
        // m개의 답
        for (int i = 0; i < m; i++) {
            String query = br.readLine();
            // 정수형으로 파싱 과정 중 문자열이 유효하지 않은 정수로 출력돼 에러 발생
            // if 조건문에서 try-catch 문으로 변경
            // 자연수 일 때
            try {
                int num = Integer.parseInt(query);
                sb.append(numList.get(num)).append('\n');
            } catch(NumberFormatException e) { // 문자열 일 때
                sb.append(strList.get(query)).append('\n');
            }
        }
        System.out.println(sb);
    }
}