package leetcode901_1000;

public class L944_DeleteColumnsToMakeSorted_easy {
    // https://leetcode.cn/problems/delete-columns-to-make-sorted/
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int ans = 0;
        for(int i = 0; i < cols; i++) {
            for(int j = 1; j < rows; j++) {
                if(strs[j].charAt(i) < strs[j-1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
