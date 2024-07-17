package Programmers.lvl1;

public class foodfight {
    public static void main(String[] args) {
        int[] food = {0, 2, 4, 3}; // 예시 입력
        System.out.println(solution(food)); // 결과 출력
    }

    public static String solution(int[] food) {
        StringBuilder answer = new StringBuilder();

        // 음식의 양을 기준으로 처리
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2; // 각 음식의 양의 절반만큼 추가
            answer.append(String.valueOf(i).repeat(Math.max(0, count))); // 음식 번호를 추가
        }

        // 음식 번호를 정방향 + 역방향으로 추가
        String foodPart = answer.toString();
        answer.append("0").append(new StringBuilder(foodPart).reverse()); // "0"과 역순 추가

        return answer.toString();
    }
}
