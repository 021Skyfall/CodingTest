import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Comparator<String> lc = (str1, str2) -> {
            int lengthCompare = Integer.compare(str1.length(), str2.length());
            if (lengthCompare == 0) {
                return str1.compareTo(str2); // 길이가 같으면 사전 순으로 비교
            }
            return lengthCompare;
        };

        Set<String> str = new TreeSet<>(lc);

        for (int i = 0; i < n; i++) {
            str.add(br.readLine());
        }

        for (String s : str) {
            System.out.println(s);
        }
    }
}