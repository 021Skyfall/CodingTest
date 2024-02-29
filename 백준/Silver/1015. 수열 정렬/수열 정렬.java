import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class B implements Comparable<B> {
    int value;
    int idx;

    public B(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }

    @Override
    public int compareTo(B o) {
        return this.value - o.value;
    }
}
public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        B[] b = new B[n];

        for (int i = 0; i < n; i++) {
            b[i] = new B(a[i], i);
        }

        Arrays.sort(b);

        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[b[i].idx] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int v : p) {
            sb.append(v).append(' ');
        }

        System.out.println(sb);
    }
}