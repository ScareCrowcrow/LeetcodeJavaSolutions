package leetcode101_200;

import java.util.LinkedList;
import java.util.List;

public class L129_SumRootToLeafNumbers_medium {
    // https://leetcode.cn/problems/sum-root-to-leaf-numbers/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> ans = new LinkedList<>();
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        traverse(root, 0);
        int sum = 0;
        for(Integer num: ans) {
            sum += num;
        }
        return sum;
    }

    void traverse(TreeNode node, int cur) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            cur = cur * 10 + node.val;
            ans.add(cur);
            cur %= 10;
        }
        cur = cur * 10 + node.val;
        traverse(node.left, cur);
        traverse(node.right, cur);
        cur %= 10;
    }
}
