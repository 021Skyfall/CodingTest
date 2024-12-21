import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[] input = new int[10024];
    static List<Integer>[] arr = new ArrayList[10];
    static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < 10; i++) {
            arr[i] = new ArrayList<>();
        }

        k = scanner.nextInt();
        int idx = 0;

        while (scanner.hasNextInt()) {
            input[idx++] = scanner.nextInt();
        }

        insertTree(0, 0, idx);
        
        for (int i = 0; i < k; i++) {
            for (int num : arr[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void insertTree(int depth, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        arr[depth].add(input[mid]);
        insertTree(depth + 1, start, mid);
        insertTree(depth + 1, mid + 1, end);
    }
}