import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cards = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int cross = makeCross(cards);
        int position = findCross(cross);

        System.out.println(position);
    }

    // 십자카드 숫자를 만듦
    public static int makeCross(int[] arr) {
        int min = 9999;
        for (int i = 0; i < 4; i++) {
            int num = arr[i] * 1000 + arr[(i + 1) % 4] * 100 + arr[(i + 2) % 4] * 10 + arr[(i + 3) % 4];
            min = Math.min(min, num);
        }

        return min;
    }

    // 몇 번째로 작은 지 체크
    public static int findCross(int num) {
        int count = 0;
        for (int i = 1111; i <= num; i++) {
            int[] arr = {i / 1000, (i / 100) % 10, (i / 10) % 10, i % 10};
            if (arr[0] != 0 && arr[1] != 0 && arr[2] != 0 && arr[3] != 0) {
                if (i == makeCross(arr)) {
                    count++;
                }
            }
        }

        return count;
    }
}