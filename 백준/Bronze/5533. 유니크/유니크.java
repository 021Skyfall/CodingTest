import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer>[] score = new ArrayList[3];

        for (int i = 0; i < 3; i++) {
            score[i] = new ArrayList<>();
        }
        List<Integer> sum = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            score[0].add(a);
            score[1].add(b);
            score[2].add(c);
        }

        for (int i = 0; i < n; i++) {
            int get = 0;
            for (int j = 0; j < 3; j++) {
                if (count(score[j], score[j].get(i)) == 1) {
                    get += score[j].get(i);
                }
            }
            sum.add(get);
        }

        for (int value : sum) {
            System.out.println(value);
        }

        scanner.close();
    }

    private static int count(List<Integer> list, int value) {
        int count = 0;
        for (int v : list) {
            if (v == value) {
                count++;
            }
        }
        return count;
    }
}