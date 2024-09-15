class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        // 왼손과 오른손의 초기 위치
        int leftPos = 10; // * 위치
        int rightPos = 12; // # 위치
        
        for (int number : numbers) {
            if (number == 0) number = 11; // 0은 11로 변환
            
            if (number % 3 == 1) { // 1, 4, 7
                answer.append("L");
                leftPos = number;
            } else if (number % 3 == 0) { // 3, 6, 9
                answer.append("R");
                rightPos = number;
            } else { // 2, 5, 8, 0
                int leftDistance = getDistance(leftPos, number);
                int rightDistance = getDistance(rightPos, number);
                
                if (leftDistance < rightDistance) {
                    answer.append("L");
                    leftPos = number;
                } else if (leftDistance > rightDistance) {
                    answer.append("R");
                    rightPos = number;
                } else { // 거리가 같을 경우
                    if (hand.equals("left")) {
                        answer.append("L");
                        leftPos = number;
                    } else {
                        answer.append("R");
                        rightPos = number;
                    }
                }
            }
        }
        
        return answer.toString();
    }
    
        private int getDistance(int pos1, int pos2) {
        // 키패드의 위치를 2D 배열로 가정
        // pos1, pos2는 0~11 (0: 0, 1~9: 1~9, 10: *, 11: #)
        int x1 = (pos1 - 1) % 3; // x 좌표
        int y1 = (pos1 - 1) / 3; // y 좌표
        int x2 = (pos2 - 1) % 3;
        int y2 = (pos2 - 1) / 3;
        
        return Math.abs(x1 - x2) + Math.abs(y1 - y2); // 맨해튼 거리
    }
}