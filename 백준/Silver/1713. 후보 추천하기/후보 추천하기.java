import java.util.*;

public class Main {

    static class Student implements Comparable<Student> {
        int cnt;
        int idx;
        int num;

        Student(int cnt, int idx, int num) {
            this.cnt = cnt;
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(Student other) {
            if (this.cnt != other.cnt) {
                return Integer.compare(this.cnt, other.cnt); // 추천 횟수 오름차순
            } else {
                return Integer.compare(this.idx, other.idx); // 인덱스 오름차순
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int studentNum = scanner.nextInt();
        int[] studentList = new int[studentNum];
        for (int i = 0; i < studentNum; i++) {
            studentList[i] = scanner.nextInt();
        }

        PriorityQueue<Student> picHeap = new PriorityQueue<>();
        List<Student> tmpHeap = new ArrayList<>();

        for (int idx = 0; idx < studentNum; idx++) {
            int num = studentList[idx];
            tmpHeap.clear();
            boolean flg = false;

            while (!picHeap.isEmpty()) {
                Student student = picHeap.poll();
                student.cnt += (student.num == num) ? 1 : 0;
                tmpHeap.add(student);
                flg |= (student.num == num);
            }

            if (!flg && tmpHeap.size() >= N) {
                tmpHeap.remove(0); // LRU 학생 제거
            }

            if (!flg) {
                tmpHeap.add(new Student(0, idx, num));
            }

            picHeap.addAll(tmpHeap);
        }

        List<Integer> answerList = new ArrayList<>();
        while (!picHeap.isEmpty()) {
            answerList.add(picHeap.poll().num);
        }

        Collections.sort(answerList);
        for (int num : answerList) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}