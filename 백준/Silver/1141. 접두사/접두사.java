import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());
        String[] words = new String[n];
        
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine().trim();
        }
        
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int res = 0;

        // 반복문을 통해 단어를 확인
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            // 현재 단어보다 길이가 긴 단어를 확인
            for (int j = i + 1; j < n; j++) {
                // 현재 단어가 접두사인지 확인
                if (words[i].equals(words[j].substring(0, words[i].length()))) {
                    flag = true;
                    break;
                }
            }
            // 현재 단어가 접두사가 아니라면 res 카운트
            if (!flag) {
                res++;
            }
        }

        System.out.println(res);
        scanner.close();
    }
}