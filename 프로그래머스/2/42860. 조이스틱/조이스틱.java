class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        // 각 문자를 'A'로 맞추기 위한 조작 횟수 계산
        for (int i = 0; i < length; i++) {
            char ch = name.charAt(i);
            answer += Math.min(ch - 'A', 'Z' - ch + 1);
        }

        // 커서 이동 최적화
        int minMove = length - 1;
        for (int i = 0; i < length; i++) {
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            minMove = Math.min(minMove, i + length - next + Math.min(i, length - next));
        }

        answer += minMove;
        return answer;
    }
}