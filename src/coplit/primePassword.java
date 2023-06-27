package coplit;

//다음의 조건을 만족하면서 현재의 비밀번호('curPwd')를 새 비밀번호(newPwd)로 변경하는 데 필요한 최소 동작의 수를 리턴해야 합니다.
//
//한 번에 한 개의 숫자만 변경가능하다.
//4자리의 소수(prime)인 비밀번호로만 변경가능하다.
//정리하면, 비밀번호가 계속 소수를 유지하도록 숫자 한 개씩을 바꿔갈 때 현재 비밀번호에서 새 비밀번호로 바꾸는 데
// 최소 몇 개의 숫자를 변경해야 하는지를 리턴해야 합니다.

//4자리인 소수는 1,000 이상의 소수를 말합니다.(0011, 0997 등은 제외)
//새 비밀번호를 만들 수 없는 경우 -1을 리턴합니다.

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class primePassword {
    public static void main(String[] args) {
        int output = primePassword(1033, 1033);
        System.out.println(output); // --> 0

        output = primePassword(3733, 8779);
        System.out.println(output); // --> 3 (3733 -> 3739 -> 3779 -> 8779)
    }
    private static int primePassword(int curPwd, int newPwd) {
        // 변경된 비밀번호가 같을 경우
        if (curPwd == newPwd) return 0;
        // bfs를 위한 queue 선언
        Queue<int[]> queue = new LinkedList<>();

        // 각 4자리의 방문 여부를 저장하는 배열
        boolean[] visited = new boolean[10000];
        // 한 번 방문한 수(가장 최소한의 동작으로 만든 수)는 다시 방문할 필요가 없음
        visited[curPwd] = true;

        // bfs를 위한 시작점
        // 큐에는 [필요한 동작 수, 비밀번호]가 저장됨
        // 배열의 첫번째 인자는 동작 수, 두번째 인자는 비밀번호
        queue.offer(new int[]{0, curPwd});

        // bfs를 큐가 빌 떄까지 탐색
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int step = data[0];
            int num = data[1];

            // 4자리 수니까 4번의 반복
            for (int i = 0; i < 4; i++) {
                int[] digits = splitNumber(num);
                // 0~9 시도
                for (int d = 0; d < 10; d++) {
                    // 각 자리의 원래 있던 수(digit[i])는 피해야함
                    if (d != digits[i]) {
                        // 현재 자리의 수 변경
                        digits[i] = d;
                        // 변경 후 4자리 수 구함
                        int next = joinDigits(digits);

                        // 만약 구한 수가 새 비밀번호와 같으면 리턴
                        if (next == newPwd) return step + 1;
                        // 1000보다 큰 소수여야 하고, 방문한적이 없어야함
                        if (next > 1000 && isPrime(next) && !visited[next]) {
                            // 방문여부를 표시
                            visited[next] = true;
                            // 큐에 넣음
                            queue.offer(new int[]{step + 1, next});
                        }
                    }
                }
            }
        }
        // 연산을 끝냈는데 리턴이 되지 않은 경우
        return -1;
    }
    // 소수
    private static boolean isPrime(int num) {
        if (num % 2 == 0) return false;
        int sqrt = (int) Math.sqrt(num);
        for (int divider = 3; divider <= sqrt; divider += 2) {
            if (num % divider == 0) return false;
        }
        return true;
    }
    // 4자리 수를 받아서 각 자리 수를 배열로 변환하는 함수
    // ex) splitNum(3359) -> [3,3,5,9]
    private static int[] splitNumber(int num) {
        return Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
    }
    // 배열 입력으로 각 자리 수의 숫자로 변환
    // 즉, 위 함수의 배열을 다시 합쳐줌
    private static int joinDigits(int[] arr) {
        String[] tempArr = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = String.valueOf(arr[i]);
        }
        return Integer.parseInt(String.join("", tempArr));
    }
}
