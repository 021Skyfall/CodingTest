import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> setA = new TreeMap<>();
        for (int i = 0; i < nA; i++) {
            setA.put(Integer.parseInt(st.nextToken()), 1);
        }

        int[] setB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < nB; i++) {
            if (setA.containsKey(setB[i])) {
                setA.put(setB[i], setA.get(setB[i]) - 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : setA.entrySet()) {
            if (entry.getValue() >= 1) {
                sb.append(entry.getKey()).append(" ");
                count++;
            }
        }

        if (sb.length() == 0) {
            System.out.println(0);
        } else {
            if (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }

            System.out.println(count);
            System.out.println(sb);
        }
    }
}