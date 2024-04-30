import java.io.*;
import java.util.*;

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.end == o.end) {
            return Integer.compare(this.start, o.start);
        }
        return Integer.compare(this.end, o.end);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings);

        int count = 0;
        int currentTime = 0;
        for (Meeting meeting : meetings) {
            if (meeting.start >= currentTime) {
                currentTime = meeting.end;
                count++;
            }
        }

        System.out.println(count);
    }
}