import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] prices = new int[m];

        for (int i = 0; i < m; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(prices);

        int maxPrice = 0;
        int maxProfit = 0;

        for (int i = 0; i < m; i++) {
            int price = prices[i];
            int profit = price * Math.min(n, m-i);
            if (profit > maxProfit) {
                maxProfit = profit;
                maxPrice = price;
            }
        }

        System.out.println(maxPrice + " " + maxProfit);
    }
}