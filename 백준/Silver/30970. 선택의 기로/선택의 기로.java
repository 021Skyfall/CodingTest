import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Chock {
    int quality;
    int price;

    public Chock(int quality, int price) {
        this.quality = quality;
        this.price = price;
    }

    // 첫 번째 방법 : 품질 우선 정렬, 동일하면 가격이 낮은 순
    static class QualityComp implements Comparator<Chock> {
        public int compare(Chock c1, Chock c2) {
            if (c1.quality == c2.quality) {
                return c1.price - c2.price;
            }
            return c2.quality - c1.quality;
        }
    }

    // 두 번째 방법 : 가격 우선 정렬, 동일하면 품질이 높은 순
    static class PriceComp implements Comparator<Chock> {
        public int compare(Chock c1, Chock c2) {
            if (c1.price == c2.price) {
                return c2.quality - c1.quality;
            }
            return c1.price - c2.price;
        }
    }
}
public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Chock> chocks = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int quality = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            chocks.add(new Chock(quality, price));
        }

        // 첫 번째 방법
        chocks.sort(new Chock.QualityComp());
        System.out.println(chocks.get(0).quality + " " + chocks.get(0).price + " " + chocks.get(1).quality + " " + chocks.get(1).price);

        // 두 번째 방법
        chocks.sort(new Chock.PriceComp());
        System.out.println(chocks.get(0).quality + " " + chocks.get(0).price + " " + chocks.get(1).quality + " " + chocks.get(1).price);
    }
}