import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] userCount = new int[N + 2]; // 각 스테이지의 사용자 수
        double[] failureRates = new double[N + 1]; // 각 스테이지의 실패율

        // 각 스테이지에 도달한 사용자 수 세기
        for (int stage : stages) {
            if (stage <= N) {
                userCount[stage]++;
            }
        }

        int totalUsers = stages.length; // 전체 사용자 수

        // 실패율 계산
        for (int i = 1; i <= N; i++) {
            if (totalUsers == 0) {
                failureRates[i] = 0; // 분모가 0인 경우 실패율은 0
            } else {
                failureRates[i] = (double) userCount[i] / totalUsers; // 실패율 계산
            }
            totalUsers -= userCount[i]; // 다음 스테이지를 위해 사용자 수 업데이트
        }

        // 스테이지와 실패율을 쌍으로 묶어 정렬
        Integer[] stageOrder = new Integer[N];
        for (int i = 0; i < N; i++) {
            stageOrder[i] = i + 1; // 스테이지 번호
        }

        // 실패율 기준으로 정렬
        Arrays.sort(stageOrder, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (failureRates[a] < failureRates[b]) {
                    return 1; // 실패율이 높은 순서로 정렬
                } else if (failureRates[a] > failureRates[b]) {
                    return -1;
                } else {
                    return a - b; // 실패율이 같으면 스테이지 번호 오름차순
                }
            }
        });

        // 결과 배열 생성
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = stageOrder[i];
        }

        return result;
    }
}