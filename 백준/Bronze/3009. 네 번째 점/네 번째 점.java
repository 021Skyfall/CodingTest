import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] c1 = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        st = new StringTokenizer(br.readLine());
        int[] c2 = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        st = new StringTokenizer(br.readLine());
        int[] c3 = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};

        int x;
        int y;

        if (c1[0] == c2[0]) {
            x = c3[0];
        } else if (c1[0] == c3[0]) {
            x = c2[0];
        } else {
            x = c1[0];
        }

        if (c1[1] == c2[1]) {
            y = c3[1];
        } else if (c1[1] == c3[1]) {
            y = c2[1];
        } else {
            y = c1[1];
        }

        System.out.println(x + " " + y);
    }
}