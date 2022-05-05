package leetcode101_200;

import java.util.ArrayList;
import java.util.List;

public class L119_PascalTriangleII_easy {
    // https://leetcode-cn.com/problems/pascals-triangle-ii/
    // 动态规划空间压缩技巧,从右往左更新
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                ans.set(j, ans.get(j - 1) + ans.get(j));
            }
            ans.add(1);
        }
        return ans;
    }
}
