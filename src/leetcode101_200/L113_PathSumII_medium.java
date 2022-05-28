package leetcode101_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L113_PathSumII_medium {
    // https://leetcode.cn/problems/path-sum-ii/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(root, path, 0, targetSum);
        return ans;
    }

    void traverse(TreeNode node, LinkedList<Integer> path, int curSum, int targetSum) {
        if(node == null) return;
        if(node.left == null && node.right == null && node.val + curSum == targetSum) {
            path.add(node.val);
            ans.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        path.add(node.val);
        traverse(node.left, path, curSum + node.val, targetSum);
        traverse(node.right, path, curSum + node.val, targetSum);
        path.removeLast();
    }
}
