package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 작은수내기 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 숫자 카드 개수

        int[] myCards = new int[n];
        int[] opCards = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            myCards[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            opCards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(myCards);
        Arrays.sort(opCards);

        int winP = (n + 1) / 2;
        int myP = 0;

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = idx; j < n; j++) {
                if (myCards[i] < opCards[j]) {
                    myP++;
                    idx = j + 1;
                    break;
                }
            }

            if (myP == winP) break;
        }

        if (myP == winP) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
