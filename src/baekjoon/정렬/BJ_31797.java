package baekjoon.정렬;

import java.io.*;
import java.util.*;

class Hand implements Comparable<Hand> {
    int height;
    int owner;

    public Hand(int height, int owner) {
        this.height = height;
        this.owner = owner;
    }

    @Override
    public int compareTo(Hand other) {
        return this.height - other.height;
    }
}

public class BJ_31797 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Hand> hands = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            hands.add(new Hand(h1, i + 1));
            hands.add(new Hand(h2, i + 1));
        }

        Collections.sort(hands);

        Hand lastHand = null;
        for (int i = 0; i < n; i++) {
            lastHand = hands.remove(0);
            hands.add(lastHand); // 가장 높은 손으로 추가
        }

        System.out.println(lastHand.owner);
    }
}
