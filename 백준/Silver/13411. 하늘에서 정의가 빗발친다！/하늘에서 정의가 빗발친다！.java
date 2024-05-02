import java.io.*;
import java.util.*;

class Robot implements Comparable<Robot> {
    int id;
    double time;

    public Robot(int id, double time) {
        this.id = id;
        this.time = time;
    }

    // 격추 시간 기준 오름차순
    @Override
    public int compareTo(Robot robot) {
        return Double.compare(this.time, robot.time);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Robot> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 로봇까지의 거리
            double distance = Math.sqrt(x*x + y*y);
            // 로봇이 격추되는 시간 = 거리 / 속도
            double time = distance / v;

            list.add(new Robot(i + 1, time));
        }

        // 격추 시간 기준 정렬
        Collections.sort(list);

        for (Robot robot : list) {
            System.out.println(robot.id);
        }
    }
}