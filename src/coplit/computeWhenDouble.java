package coplit;

// 연이율을 입력받아 원금이 2배 이상이 될 때까지 걸리는 시간(년)을 리턴해야 합니다.

//int 타입을 리턴해야 합니다.

public class computeWhenDouble {
    public static void main(String[] args) {
        int output = computeWhenDouble(7);
//        System.out.println(output); // --> 11
    }
    private static int computeWhenDouble(double interestRate) {
        double rate = 1 + interestRate / 100;
        System.out.println("이율 : " + rate + "\n");
        double principal = 1;
        int year = 0;
        while (principal < 2) {
            year++;
            System.out.println("연차 : " + year);

            principal = principal * rate;
            System.out.println("원금 : " + principal + "\n");
        }
        return year;
    }
}

