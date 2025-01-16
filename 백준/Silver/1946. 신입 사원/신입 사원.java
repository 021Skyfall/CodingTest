import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(reader.readLine());
        int[] cntArray = new int[T];
        
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.readLine());
            int[][] score = new int[N][2];
            
            for (int j = 0; j < N; j++) {
                String[] input = reader.readLine().split(" ");
                score[j][0] = Integer.parseInt(input[0]);
                score[j][1] = Integer.parseInt(input[1]);
            }

            // 첫 번째 값을 기준으로 오름차순 정렬
            Arrays.sort(score, (a, b) -> Integer.compare(a[0], b[0]));

            int maxScore = Integer.MAX_VALUE;
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (score[j][1] < maxScore) {
                    cnt++;
                    maxScore = score[j][1];
                }
            }

            cntArray[i] = cnt;
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < T; i++) {
            output.append(cntArray[i]).append("\n");
        }
        System.out.print(output);
    }
}