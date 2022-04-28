package leetcode801_900;

import java.util.*;

public class Problem863 {
    /*
    * step1.生成父亲表，可以从上遍历
    * step2.图的宽度优先遍历，获取第k层节点
    */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        createParentMap(root, parents);
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int curLevel = 0;
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 同一批(同一层)操作一次
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (curLevel == k) {
                    ans.add(cur.val);
                }
                if (cur.left != null && !visited.contains(cur.left)) {
                    visited.add(cur.left);
                    queue.offer(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right)) {
                    visited.add(cur.right);
                    queue.offer(cur.right);
                }
                if (parents.get(cur) != null && !visited.contains(parents.get(cur))) {
                    visited.add(parents.get(cur));
                    queue.offer(parents.get(cur));
                }
            }
            curLevel++;
            if (curLevel > k) {
                break;
            }
        }
        return ans;
    }

    public void createParentMap(TreeNode cur, HashMap<TreeNode, TreeNode> parents) {
        if (cur == null) {
            return;
        }
        if (cur.left != null) {
            parents.put(cur.left, cur);
            createParentMap(cur.left, parents);
        }
        if (cur.right != null) {
            parents.put(cur.right, cur);
            createParentMap(cur.right, parents);
        }
    }
}
