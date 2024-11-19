package leetcode801_900;

import java.util.*;

public class L863_DistanceK_medium {
    // https://leetcode.cn/problems/all-nodes-distance-k-in-binary-tree/?envType=study-plan-v2&envId=graph-theory
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<Integer, List<Integer>> adj = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 构建无向图
        constructGraph(root);
        // BFS
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(target.val);
        visited.add(target.val);
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty() && k >= 0) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                if (k == 0) {
                    ans.add(cur);
                }
                for (int nei: adj.getOrDefault(cur, new ArrayList<>())) {
                    if (!visited.contains(nei)) {
                        q.offer(nei);
                        visited.add(nei);
                    }
                }
            }
            k--;
        }
        return ans;

    }

    private void constructGraph(TreeNode node) {
        if (node.left != null) {
            adj.putIfAbsent(node.val, new ArrayList<>());
            adj.get(node.val).add(node.left.val);
            adj.putIfAbsent(node.left.val, new ArrayList<>());
            adj.get(node.left.val).add(node.val);
            constructGraph(node.left);
        }
        if (node.right != null) {
            adj.putIfAbsent(node.val, new ArrayList<>());
            adj.get(node.val).add(node.right.val);
            adj.putIfAbsent(node.right.val, new ArrayList<>());
            adj.get(node.right.val).add(node.val);
            constructGraph(node.right);
        }
    }
}
