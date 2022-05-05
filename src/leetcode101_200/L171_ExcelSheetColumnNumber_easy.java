package leetcode101_200;

public class L171_ExcelSheetColumnNumber_easy {
    // https://leetcode-cn.com/problems/excel-sheet-column-number/
    public static int titleToNumber(String s) {
        char[] str = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < str.length; i++) {
            ans = ans * 26 + (str[i] - 'A') + 1;
        }
        return ans;
    }
}
