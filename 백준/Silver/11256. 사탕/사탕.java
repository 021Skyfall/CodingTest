import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        
        while (T-- > 0) {
            int J = scanner.nextInt();
            int N = scanner.nextInt();
            
            List<Integer> arr = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                int r = scanner.nextInt(); // 상자의 행
                int c = scanner.nextInt(); // 상자의 열
                arr.add(r * c); // 크기 저장
            }

            Collections.sort(arr, Collections.reverseOrder());

            int cnt = 0; // 상자 갯수
            
            for (int i = 0; i < N; i++) {
                J -= arr.get(i); // 상자에 사탕 넣기
                cnt++;
                
                if (J <= 0) { // 모두 넣은 경우
                    break; // 종료
                }
            }

            System.out.println(cnt);
        }

        scanner.close();
    }
}