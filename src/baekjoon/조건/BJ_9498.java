package baekjoon.조건;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9498 {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.parseInt(br.readLine());

        if (result >= 90) System.out.println("A");
        else if (result >= 80) System.out.println("B");
        else if (result >= 70) System.out.println("C");
        else if (result >= 60) System.out.println("D");
        else System.out.println("F");

        // 데이터를 읽은 후 리소스를 해제하여 프로그램 종료 시 자원 누수 방지, 자원을 효율적으로 관리하기 위함
        // java 7부터 try-with-resource 문을 사용하여 자동으로 close() 매서드를 호출할 수 있는 구문 제공
        // java에서는 가비지 컬렉션 매커니즘을 통해 자동으로 참조 하지 않는 객체를 매모리에서 해제하지만
        // 입출력과 같은 외부 리소스는 가비지 컬렉션의 대상이 되지 않음
        br.close();
    }
    private static void second() throws java.io.IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.parseInt(br.readLine());
        String grade;
        switch (result / 10) {
            case 10: case 9:
                grade = "A"; break;
            case 8: grade = "B"; break;
            case 7: grade = "C"; break;
            case 6: grade = "D"; break;
            default: grade = "F"; break;
        }
        System.out.println(grade);
        br.close();
    }
}
