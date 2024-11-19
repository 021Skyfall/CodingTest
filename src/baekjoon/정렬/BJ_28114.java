package baekjoon.정렬;

import java.util.*;

public class BJ_28114 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = new ArrayList<>();
        List<Pair> secondList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String P = scanner.next();
            int Y = scanner.nextInt();
            String S = scanner.next();
            firstList.add(Y);
            secondList.add(new Pair(Integer.parseInt(P), S));
        }

        Collections.sort(firstList);
        Collections.sort(secondList, (a, b) -> b.value - a.value);

        StringBuilder firstTeamName = new StringBuilder();
        StringBuilder secondTeamName = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            firstTeamName.append(firstList.get(i) % 100);
            secondTeamName.append(secondList.get(i).name.charAt(0));
        }

        System.out.println(firstTeamName);
        System.out.println(secondTeamName);

        scanner.close();
    }

    static class Pair {
        int value;
        String name;

        Pair(int value, String name) {
            this.value = value;
            this.name = name;
        }
    }
}
