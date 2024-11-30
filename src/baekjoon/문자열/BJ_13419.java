package baekjoon.문자열;

import java.util.*;

public class BJ_13419 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        List<String> games = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            games.add(scanner.nextLine());
        }

        for (String game : games) {
            StringBuilder evenIndexChars = new StringBuilder();
            StringBuilder oddIndexChars = new StringBuilder();

            for (int i = 0; i < game.length(); i++) {
                if (i % 2 == 0) {
                    evenIndexChars.append(game.charAt(i));
                } else {
                    oddIndexChars.append(game.charAt(i));
                }
            }

            if (game.length() % 2 == 0) {
                System.out.println(evenIndexChars);
                System.out.println(oddIndexChars);
            } else {
                System.out.println(evenIndexChars.toString() + oddIndexChars.toString());
                System.out.println(oddIndexChars.toString() + evenIndexChars.toString());
            }
        }
        scanner.close();
    }
}
