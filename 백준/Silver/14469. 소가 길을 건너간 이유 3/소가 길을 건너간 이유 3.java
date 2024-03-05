import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Cow implements Comparable<Cow> {
    int arriveTime;
    int crossTime;

    public Cow(int arriveTime, int crossTime) {
        this.arriveTime = arriveTime;
        this.crossTime = crossTime;
    }

    @Override
    public int compareTo(Cow cow) {
        if (this.arriveTime == cow.arriveTime) {
            return this.crossTime - cow.crossTime;
        } else {
            return this.arriveTime - cow.arriveTime;
        }
    }
}

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Cow> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arriveTime = Integer.parseInt(st.nextToken());
            int crossTime = Integer.parseInt(st.nextToken());
            pq.offer(new Cow(arriveTime, crossTime));
        }

        int result = 0;
        while (!pq.isEmpty()) {
            Cow cow = pq.poll();
            if (cow.arriveTime > result) {
                result = cow.arriveTime;
            }
            result += cow.crossTime;
        }

        System.out.println(result);
    }
}