package Programmers.lvl1;

public class Year2016 {
    public static void main(String[] args) {
        int month = 5; // 예시: 5월
        int day = 24;  // 예시: 24일

        String result = solution(month, day);

        // 결과 출력
        System.out.println(result); // 요일 출력
    }

    public static String solution(int a, int b) {
        // 2016년의 각 달의 일 수
        int[] daysInMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        // 주어진 날짜까지의 총 일 수 계산
        int totalDays = b; // 해당 월의 일 수 추가

        // 주어진 월 이전의 모든 월의 일 수 합산
        for (int i = 1; i < a; i++) {
            totalDays += daysInMonth[i];
        }

        // 2016년 1월 1일이 금요일이므로, 이를 기준으로 요일 계산
        return dayOfWeek[totalDays % 7];
    }
}
