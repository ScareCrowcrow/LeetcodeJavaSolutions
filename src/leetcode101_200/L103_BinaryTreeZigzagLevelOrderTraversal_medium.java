package leetcode101_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L103_BinaryTreeZigzagLevelOrderTraversal_medium {
    // https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int size = 0;
        boolean isHead = true;
        while (!deque.isEmpty()) {
            size = deque.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = isHead ? deque.pollFirst() : deque.pollLast();
                curLevel.add(cur.val);
                if(isHead) {
                    if (cur.left != null) {
                        deque.addLast(cur.left);
                    }
                    if (cur.right != null) {
                        deque.addLast(cur.right);
                    }
                }else {
                    if (cur.right != null) {
                        deque.addFirst(cur.right);
                    }
                    if (cur.left != null) {
                        deque.addFirst(cur.left);
                    }
                }
            }
            ans.add(curLevel);
            isHead = !isHead;
        }
        return ans;
    }
}
