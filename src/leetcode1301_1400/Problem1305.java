package leetcode1301_1400;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1305 {
    // https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> ans = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inOrderTraversal(root1);
        inOrderTraversal(root2);
        Collections.sort(ans);
        return ans;
    }

    public void inOrderTraversal(TreeNode t){
        if(t == null) return;
        inOrderTraversal(t.left);
        ans.add(t.val);
        inOrderTraversal(t.right);
    }
}
