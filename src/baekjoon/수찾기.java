package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 수찾기 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for(String s : br.readLine().split(" ")) set.add(Integer.parseInt(s));

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(String s : br.readLine().split(" ")) {
            if(set.contains(Integer.parseInt(s))) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }

        System.out.println(sb);
    }
}