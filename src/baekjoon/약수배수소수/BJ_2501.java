package baekjoon.약수배수소수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2501 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                stack.add(i);
            }
        }

        if (stack.size() < k)
            System.out.println(0);
        else
            System.out.println(stack.get(k - 1));
    }
}
