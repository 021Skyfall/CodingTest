package coplit;

// 한 변의 길이가 2의 제곱수인 정사각형의 흑백 이미지가 2차원 배열로 주어집니다.
// 각 좌표에는 0(백) 또는 1(흑)이 저장되어 있습니다.
// 이미지에 포함된 데이터가 모두 1이면 "1", 모두 0이면 "0" 한 글자로 압축할 수 있습니다.
// 그렇지 않은 경우, 이를 대문자 X로 표시하고 전체를 4등분하여 재귀적으로 압축합니다.
// 4등분한 영역의 순서는 좌측 상단, 우측 상단, 좌측 하단, 우측 하단입니다.

//두 배열의 길이의 합은 1,000,000 이하입니다.
//어떤 배열 arr의 k번째 요소는 arr[k-1]을 의미합니다.

public class decompression {
    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1, 0, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 0}
        };
        String result = decompression(image);
        System.out.println(result); // --> "XX100110X1100​"

        image = new int[][]{
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1}
        };
        String result1 = decompression(image);
        System.out.println(result1); // --> 'X0X101X10101X00X10011'
    }
    private static String decompression(int[][] image) {
        return aux(0, image.length -1, 0, image.length -1, image);
    }
    // 재귀를 위한 보조 함수
    // 파라미터는 차례대로
    // y좌표의 시작(row Start),
    // y좌표의 끝(row End),
    // x좌표의 시작(col Start),
    // x좌표의 끝(col End)
    private static String aux(int rs, int re, int cs, int ce, int[][] image) {
        //base case
        // 각 좌표에는 number 타입이 저장되어 있음
        if (rs == re) return String.valueOf(image[rs][cs]);

        // 좌상 우상 좌하 우하로 구분
        int midRow = (int)Math.floor((rs + re) / 2);
        int midCol = (int)Math.floor((cs + ce) / 2);
        String leftUpper = aux(rs, midRow, cs, midCol, image);
        String rightUpper = aux(rs, midRow, midCol + 1, ce, image);
        String leftDown = aux(midRow + 1, re, cs, midCol, image);
        String rightDown = aux(midRow + 1, re, midCol + 1, ce, image);

        // 주어진 사각형 전체를 순회하고 나서 재귀를 하거나
        // 4등분한 각 사각형을 각각 순회하고 나서 재귀를 하는 방식은
        // 데이터를 중복 조회하게 됨
        // 재귀적으로 각 결과를 합치면서 계산하면 모든 좌표를 한 번씩만 검토하면 됨
        String result = leftUpper + rightUpper + leftDown + rightDown;
        if (result.equals("1111")) return "1";
        else if (result.equals("0000")) return "0";
        else return "X"+ result;
    }
}
