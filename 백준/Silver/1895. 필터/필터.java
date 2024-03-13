import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] image = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                image[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int t = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i <= r - 3; i++) {
            for (int j = 0; j <= c - 3; j++) {
                List<Integer> values = new ArrayList<>();

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        values.add(image[i + k][j + l]);
                    }
                }

                Collections.sort(values);
                int mid = values.get(4);

                if (mid >= t) {
                    count++;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}