package leetcode101_200;

import javafx.util.Pair;
import java.util.LinkedList;
import java.util.Queue;

public class L111_MinimumDepthOfBinaryTree_easy {
    // https://leetcode.cn/problems/minimum-depth-of-binary-tree/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // 递归
    public int minDepth(TreeNode root){
        if (root == null) return 0;
        if ((root.left == null) && (root.right == null)) return 1;
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null){
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null){
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }

    // DFS
    public int minDepth2(TreeNode root){
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) return 0;
        else stack.add(new Pair<>(root, 1));

        int min_depth = Integer.MAX_VALUE;
        while (!stack.isEmpty()){
            Pair<TreeNode, Integer> cur = stack.pollLast();
            root = cur.getKey();
            int cur_depth = cur.getValue();
            if ((root.left == null) && (root.right == null)){
                min_depth = Math.min(min_depth, cur_depth);
            }
            if (root.left != null){
                stack.add(new Pair<>(root.left, cur_depth + 1));
            }
            if (root.right != null){
                stack.add(new Pair<>(root.right, cur_depth + 1));
            }
        }
        return min_depth;
    }

    // BFS
    public int minDepth3(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 遍历当前层的节点 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 判断是否到达叶子结点 */
                if (cur.left == null && cur.right == null)
                    return depth;
                /* 将下一层节点加入队列 */
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            /* 这里增加步数 */
            depth++;
        }
        return depth;
    }

    // Morris遍历
    public int minDepth4(TreeNode head) {
        if (head == null) {
            return 0;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        int curLevel = 0;
        int minHeight = Integer.MAX_VALUE;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                int rightBoardSize = 1;
                while (mostRight.right != null && mostRight.right != cur) {
                    rightBoardSize++;
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) { // 第一次到达
                    curLevel++;
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else { // 第二次到达
                    if (mostRight.left == null) {
                        minHeight = Math.min(minHeight, curLevel);
                    }
                    curLevel -= rightBoardSize;
                    mostRight.right = null;
                }
            } else { // 只有一次到达
                curLevel++;
            }
            cur = cur.right;
        }
        int finalRight = 1;
        cur = head;
        while (cur.right != null) {
            finalRight++;
            cur = cur.right;
        }
        if (cur.left == null && cur.right == null) {
            minHeight = Math.min(minHeight, finalRight);
        }
        return minHeight;
    }
}
