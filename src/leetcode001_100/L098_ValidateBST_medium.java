package leetcode001_100;

import java.util.Stack;

public class L098_ValidateBST_medium {
    // https://leetcode-cn.com/problems/validate-binary-search-tree/
     public static class TreeNode {
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

    public boolean isValidBST(TreeNode root) {
        if(root != null) {
            long preValue = Long.MIN_VALUE;
            Stack<TreeNode> stack = new Stack<>();
            while(!stack.isEmpty() || root != null) {
                if(root != null) {
                    stack.push(root);
                    root = root.left;
                }else{
                    root = stack.pop();
                    if(root.val <= preValue) {
                        return false;
                    } else {
                        preValue = root.val;
                    }
                    root = root.right;
                }
            }
        }
        return true;
    }

    // Morris遍历
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        Integer pre = null;
        boolean ans = true;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            if (pre != null && pre >= cur.val) {
                ans = false;
            }
            pre = cur.val;
            cur = cur.right;
        }
        return ans;
    }
}
