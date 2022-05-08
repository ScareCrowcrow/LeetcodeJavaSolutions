package leetcode401_500;

import java.util.ArrayList;
import java.util.List;

public class L442_FindAllDuplicatesInAnArray_medium {
    // https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        // 遍历数组，在每个数字上加2N，第二次遍历数组时，超过2N的元素就是出现多次的元素
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % n] += n;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
