package coplit;

//두 수(num1, num2)를 입력받아, num1를 num2로 나눈 나머지를 리턴해야 합니다.

//나눗셈(/), 나머지(%) 연산자 사용은 금지됩니다.
//0은 어떤 수로 나누어도 나머지가 0입니다.
//어떤 수도 0으로 나눌 수 없습니다. 이 경우 null를 리턴해야 합니다.
//주석에서 사용하는(/)도 나눗셈으로 간주하기 때문에, 주석을 모두 지워야 합니다.

public class modulo {
    public static void main(String[] args) {
        Integer output = modulo(25, 4);
        System.out.println(output); // --> 1
    }
    public static Integer modulo(int num1, int num2) {
        if (num2 == 0) return null;
        return Math.floorMod(num1,num2);
    }
}
