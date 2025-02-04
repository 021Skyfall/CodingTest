package baekjoon.정렬;

import java.io.*;
import java.util.*;

public class BJ_16212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        StringJoiner sj = new StringJoiner(" ");
        for (int i : list) {
            sj.add(String.valueOf(i));
        }

        System.out.println(sj);
    }
}