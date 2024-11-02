import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        scanner.nextLine();
        
        String[] arr = new String[H];
        for (int h = 0; h < H; h++) {
            arr[h] = scanner.nextLine();
        }
        
        for (String a : arr) {
            int[] lst = new int[W];
            for (int i = 0; i < W; i++) {
                lst[i] = -1;
                if (a.charAt(i) == 'c') {
                    lst[i] = 0;
                }
            }
            int tmp = 0;
            for (int i = 1; i < W; i++) {
                if (lst[i] == 0) {
                    tmp = 0;
                }
                if (lst[i - 1] != -1) {
                    if (lst[i] != 0) {
                        tmp++;
                        lst[i] = tmp;
                    }
                }
            }
            for (int i = 0; i < W; i++) {
                System.out.print(lst[i] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}