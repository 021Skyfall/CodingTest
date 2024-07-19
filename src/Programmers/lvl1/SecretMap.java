package Programmers.lvl1;

public class SecretMap {
    public static void main(String[] args) {
        int n = 5; // 지도 크기
        int[] arr1 = {9, 20, 28, 18, 11}; // 첫 번째 배열
        int[] arr2 = {30, 1, 21, 17, 28}; // 두 번째 배열

        String[] result = solution(n, arr1, arr2);

        // 결과 출력
        for (String row : result) {
            System.out.println(row);
        }
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            // 두 배열의 원소를 OR 연산하여 비밀지도를 생성
            int map = arr1[i] | arr2[i];
            // 이진수로 변환하고, n자리의 문자열로 만든 후 '#', ' '로 변환
            StringBuilder binaryMap = new StringBuilder(Integer.toBinaryString(map));
            while (binaryMap.length() < n) {
                binaryMap.insert(0, '0'); // n자리로 맞추기 위해 앞에 0 추가
            }
            // '#'과 ' '로 변환
            answer[i] = binaryMap.toString().replace('1', '#').replace('0', ' ');
        }

        return answer;
    }
}
