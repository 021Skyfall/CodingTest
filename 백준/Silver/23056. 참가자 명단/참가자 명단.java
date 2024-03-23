import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Student implements Comparable<Student> {
    int classNumber;
    String name;

    public Student(int classNumber, String name) {
        this.classNumber = classNumber;
        this.name = name;
    }

    @Override
    public int compareTo(Student student) {
        // 이름의 길이가 같으면 사전 순으로, 아니면 이름 길이에 따라 정렬
        if (this.name.length() == student.name.length()) {
            return this.name.compareTo(student.name);
        } else {
            return this.name.length() - student.name.length();
        }
    }
}

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, PriorityQueue<Student>> oddClassMap = new HashMap<>();
        Map<Integer, PriorityQueue<Student>> evenClassMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                oddClassMap.put(i, new PriorityQueue<>());
            } else {
                evenClassMap.put(i, new PriorityQueue<>());
            }
        }

        String line;
        while (!(line = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(line, " ");
            int classNumber = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if (classNumber % 2 == 1) {
                PriorityQueue<Student> pq = oddClassMap.get(classNumber);
                if (pq.size() < m) {
                    pq.add(new Student(classNumber, name));
                }
            } else {
                PriorityQueue<Student> pq = evenClassMap.get(classNumber);
                if (pq.size() < m) {
                    pq.add(new Student(classNumber, name));
                }
            }
        }

        // 홀수 클래스 번호 학생들 먼저 출력
        for (int i = 1; i <= n; i += 2) {
            PriorityQueue<Student> pq = oddClassMap.get(i);
            while (pq != null && !pq.isEmpty()) {
                Student student = pq.poll();
                System.out.println(student.classNumber + " " + student.name);
            }
        }

        // 짝수 클래스 번호 학생들 출력
        for (int i = 2; i <= n; i += 2) {
            PriorityQueue<Student> pq = evenClassMap.get(i);
            while (pq != null && !pq.isEmpty()) {
                Student student = pq.poll();
                System.out.println(student.classNumber + " " + student.name);
            }
        }
    }
}