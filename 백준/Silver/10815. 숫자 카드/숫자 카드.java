import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        HashSet<Integer> deck = new HashSet<>();
        for (int i = 0; i < n; i++) {
            deck.add(Integer.parseInt(st.nextToken()));
        }

        int x = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            if (deck.contains(i))
               bw.append('1').append(" ");
            else bw.append('0').append(" ");
        }
        bw.flush();
    }
}