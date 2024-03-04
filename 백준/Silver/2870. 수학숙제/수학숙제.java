import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<BigInteger> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(str);

            while (matcher.find()) {
                nums.add(new BigInteger(matcher.group()));
            }
        }

        Collections.sort(nums);
        StringBuilder sb = new StringBuilder();
        for (BigInteger num : nums) {
            sb.append(num).append('\n');
        }

        System.out.println(sb);
    }
}