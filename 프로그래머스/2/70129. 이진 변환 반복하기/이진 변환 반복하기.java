class Solution {
    public int[] solution(String s) {
        int count = 0;
        int total = 0;
        while (!s.equals("1")) {
            StringBuilder num = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == '1')
                    num.append("1");
                else
                    total++;
            }

            s = Integer.toBinaryString(num.length());

            count++;
        }

        int[] result = new int[2];
        result[0] = count;
        result[1] = total;
        return result;
    }
}