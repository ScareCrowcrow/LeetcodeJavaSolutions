package leetcode701_800;

import java.util.ArrayList;
import java.util.List;

public class L763_PartitionLabels_medium {
    // https://leetcode.cn/problems/partition-labels/
    // 记录每个字符最靠右的位置
    public static List<Integer> partitionLabels(String S) {
        char[] str = S.toCharArray();
        int[] far = new int[26];
        for (int i = 0; i < str.length; i++) {
            far[str[i] - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = far[str[0] - 'a'];
        for (int i = 1; i < str.length; i++) {
            if (i > right) {
                ans.add(right - left + 1);
                left = i;
            }
            right = Math.max(right, far[str[i] - 'a']);
        }
        ans.add(right - left + 1);
        return ans;
    }
}
