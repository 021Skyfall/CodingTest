import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int totalWeightOnBridge = 0;
        int time = 0;
        int index = 0;

        // 초기화: 다리 길이만큼 0으로 채우기
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while (index < truck_weights.length) {
            time++;
            // 다리에서 트럭을 내리기
            totalWeightOnBridge -= bridge.poll();

            // 새로운 트럭을 다리에 올릴 수 있는지 확인
            if (totalWeightOnBridge + truck_weights[index] <= weight) {
                bridge.add(truck_weights[index]);
                totalWeightOnBridge += truck_weights[index];
                index++;
            } else {
                // 다리 길이를 유지하기 위해 0 추가
                bridge.add(0);
            }
        }

        // 마지막 트럭이 다리를 완전히 건너는 시간 추가
        time += bridge_length;

        return time;
    }
}