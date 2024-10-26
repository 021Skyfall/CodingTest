package baekjoon.그리디;

import java.util.Scanner;

public class Dif5And6_2864 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.next();
        String b = scanner.next();

        int mn = Integer.parseInt(a.replace('6', '5')) + Integer.parseInt(b.replace('6', '5'));
        int mx = Integer.parseInt(a.replace('5', '6')) + Integer.parseInt(b.replace('5', '6'));

        System.out.println(mn + " " + mx);

        scanner.close();
    }
}