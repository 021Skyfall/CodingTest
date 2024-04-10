import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            ArrayList<Long> distances = new ArrayList<>();
            int[][] points = new int[4][2];

            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            // 모든 점 사이의 거리를 계산 후 distances에 추가
            /* 
            네점으로 이루어진 도형에서 점 쌍 간 거리는 6개
            정사각형 = 네 변의 길이가 같음 + 대각선 길이가 같음
            */
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    long dist = (long) (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                    distances.add(dist);
                }
            }

            // 거리 리스트 정렬
            // 네 변의 길이 < 대각선 길이
            Collections.sort(distances);

            // 정사각형인 경우, 4변의 길이가, 대각선 길이가 같아야함
            if (distances.get(0).equals(distances.get(1))
                    && distances.get(0).equals(distances.get(2))
                    && distances.get(0).equals(distances.get(3))
                    && distances.get(4).equals(distances.get(5))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}