class Solution {
    public int solution(String s) {
        int answer = s.length();

        // 1부터 문자열 길이의 절반까지를 단위로 설정
        for (int unit = 1; unit <= s.length() / 2; unit++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, unit);
            int count = 1;

            // 단위 길이만큼 잘라가며 압축
            for (int j = unit; j <= s.length(); j += unit) {
                String sub;
                if (j + unit > s.length()) {
                    sub = s.substring(j);
                } else {
                    sub = s.substring(j, j + unit);
                }

                if (prev.equals(sub)) {
                    count++;
                } else {
                    if (count > 1) {
                        compressed.append(count);
                    }
                    compressed.append(prev);
                    prev = sub;
                    count = 1;
                }
            }

            if (count > 1) {
                compressed.append(count);
            }
            compressed.append(prev);

            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}