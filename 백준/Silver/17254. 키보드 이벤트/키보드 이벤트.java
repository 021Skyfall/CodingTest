import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); // 이 변수는 사용되지 않으므로 제거 가능
        int b = Integer.parseInt(st.nextToken());

        int[][] inputs = new int[b][3]; // 시간, 키보드 번호, 문자의 아스키 코드를 저장할 배열

        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            int keyboard = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);

            inputs[i][0] = time;
            inputs[i][1] = keyboard;
            inputs[i][2] = ch;
        }

        // 배열을 시간 -> 키보드 번호 순으로 정렬
        java.util.Arrays.sort(inputs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]); // 시간이 같을 경우 키보드 번호로 비교
                }
                return Integer.compare(o1[0], o2[0]); // 먼저 시간을 기준으로 정렬
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int[] input : inputs) {
            sb.append((char) input[2]); // 문자의 아스키 코드를 문자로 변환하여 추가
        }

        System.out.println(sb);
    }
}