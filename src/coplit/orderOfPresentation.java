package coplit;

//말썽꾸러기 김코딩은 오늘도 장난을 치다가 조별 발표 순서가 담긴 통을 쏟고 말았습니다.
//
//선생님께서는 미리 모든 발표 순서의 경우의 수를 저장해 놓았지만 김코딩의 버릇을 고치기 위해 문제를 내겠다고 말씀하셨습니다.
//
//김코딩은 모든 조별 발표 순서에 대한 경우의 수를 차례대로 구한 뒤 발표 순서를 말하면 이 발표 순서가 몇 번째 경우의 수인지를 대답해야 합니다.
//
//총 조의 수 N과 선생님이 말씀하시는 발표 순서 k가 주어질 때, 김코딩이 정답을 말 할 수 있게 올바른 리턴 값을 구하세요.
//
//모든 경우의 수가 담긴 배열은 번호가 작을수록 앞에 위치한다고 가정합니다.
//ex) N = 3일경우, [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

//k내에 중복되는 요소는 없다고 가정합니다.

import java.util.Arrays;

public class orderOfPresentation {
    public static void main(String[] args) {
        int output = orderOfPresentation(5, new int[]{1, 3, 2, 4, 5});
        System.out.println(output); // 6
    }
    private static int orderOfPresentation(int N, int[] K) {
        // N개의 조가 있을 때 발표순서를 중복없는 경우의 수로 나타낸 뒤
        // K 라는 발표순서가 담긴 안쪽배열의 순서를 리턴하면 됨
        // 순열 문제
        // 근데 배열 K의 위치만 가져오면 되니까
        // 순열을 전부 완성할 필요는 없어보임
        // 중간에 K와 일치하는 값을 찾는다면 인덱스 리턴하게
        // 그럼 순서을 담아서 비교해야함

        // 발표 순서
        int order = 0;

        // 중복된 필요가 없으므로 DFS 방식으로 방문 여부 체크
        // 단, 조는 1부터 시작이기 때문에 방문 체크 배열은 4의 길이가 되어야함
        boolean[] visited = new boolean[N + 1];

        // k의 길이만큼 순회하고
        for (int i = 0; i < K.length; i++) {
            //K의 i 번째 요소를 변수에 할당함
            int num = K[i];
            // 중복이 아니니까 해당 자리는 방문함
            visited[num] = true;
            // K의 i 번째 요소보다 앞에 올 수 있는 배열을 복제
            boolean[] forward = Arrays.copyOfRange(visited, 1, num);
            // 위에서 복제된 배열에서 아직 사용되지 않은 경우의 수 개수를 구함
            int val= 0;
            for (boolean fw : forward) if (!fw) val++;
            // 아직 사용되지 않은 경우의 수 카운트
            int former = val * factorial(N - i - 1);
            // 해당 카운트를 order에 더함
            order = order + former;
        }
        return order;
    }
    private static int factorial(int n) {
        if (n <= 1) return 1;
        return  n * factorial(n-1);
    }
}
