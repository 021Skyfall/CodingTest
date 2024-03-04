import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        List<Pair> list = new ArrayList<>();

        for (int i = m; i<= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i >= 10) sb.append(words[i / 10]).append(" ");
            sb.append(words[i % 10]);
            list.add(new Pair(i, sb.toString()));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).num + " ");
            if (i % 10 == 9) System.out.println();
        }
    }

    static class Pair implements Comparable<Pair> {
        int num;
        String str;

        public Pair(int num, String str) {
            this.num = num;
            this.str = str;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.str.compareTo(pair.str);
        }
    }
}