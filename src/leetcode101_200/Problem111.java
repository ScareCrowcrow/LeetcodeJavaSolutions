package leetcode101_200;

import javafx.util.Pair;
import java.util.LinkedList;

public class Problem111 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root){
        // 递归
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
    public int minDepth3(TreeNode root){
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) return 0;
        else stack.add(new Pair<>(root, 1));

        int cur_depth = 0;
        while (!stack.isEmpty()){
            Pair<TreeNode, Integer> cur = stack.poll();
            root = cur.getKey();
            cur_depth = cur.getValue();
            if ((root.left == null) && (root.right == null)) break;
            if (root.left != null) stack.add(new Pair<>(root.left, cur_depth + 1));
            if (root.right != null) stack.add(new Pair<>(root.right, cur_depth + 1));
        }
        return cur_depth;
    }
}
