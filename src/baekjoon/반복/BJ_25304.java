package baekjoon.반복;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//public class BJ_25304 {
//    public static void main(String[] args) throws java.io.IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int total = Integer.parseInt(br.readLine());
//        int num = Integer.parseInt(br.readLine());
//        int result = 0;
//
//        for (int i = 0; i < num; i++) {
//            String priceAndCount = br.readLine();
//            String[] pac = priceAndCount.split(" ");
//            int price = Integer.parseInt(pac[0]);
//            int count = Integer.parseInt(pac[1]);
//
//            result += (price * count);
//        }
//        br.close();
//
//        if (total == result) System.out.println("Yes");
//        else System.out.println("No");
//    }
//}
import java.util.Scanner;

public class BJ_25304 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int num = scanner.nextInt();

        int result = 0;

        for (int i = 0; i < num; i++){
            int price = scanner.nextInt();
            int count = scanner.nextInt();
            result += (price * count);
        }
        scanner.close();

        if (total == result) System.out.println("Yes");
        else System.out.println("No");
    }
}
