import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Order {
        int table;
        int time;

        public Order(int table, int time) {
            this.table = table;
            this.time = time;
        }
    }
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Order> orders = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String act = st.nextToken();

            switch (act) {
                case "order": {
                    int table = Integer.parseInt(st.nextToken());
                    int time = Integer.parseInt(st.nextToken());
                    orders.add(new Order(table, time));
                    break;
                }
                case "sort":
                    orders.sort(Comparator.comparingInt((Order o) -> o.time)
                            .thenComparingInt(o -> o.table));
                    break;
                case "complete": {
                    int table = Integer.parseInt(st.nextToken());
                    orders.removeIf(order -> order.table == table);
                    break;
                }
            }

            if (orders.isEmpty()) {
                System.out.println("sleep");
            } else {
                orders.forEach(order -> System.out.print(order.table + " "));
                System.out.println();
            }
        }
    }
}