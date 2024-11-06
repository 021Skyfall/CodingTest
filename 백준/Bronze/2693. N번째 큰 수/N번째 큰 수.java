import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();
        int[] arr = new int[10];

        for (int j = 0; j < testcase; j++) {
            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(arr[7]);
        }

        sc.close();
    }
}