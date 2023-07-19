package baekjoon.조건;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ_1330 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] result = str.split(" ");
        int a = Integer.parseInt(result[0]) - '0';
        System.out.println(a);
        int b = Integer.parseInt(result[1]) - '0';
        System.out.println(b);

        if (a > b) System.out.println(">");
        if (a < b) System.out.println("<");
        if (a == b) System.out.println("==");

        second();
    }
    private static void second() throws java.io.IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bufferedReader.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        System.out.println(a);
        int b = Integer.parseInt(str[1]);
        System.out.println(b);

        System.out.println((a > b) ? ">" : (a < b) ? "<" : "==");
    }
}
