package summarize;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 树的遍历分为深度优先搜索(DFS)和广度优先搜索(BFS)
* DFS分为先序、中序、后序遍历
* BFS即为层次遍历
*
* 二叉搜索树的中序遍历是顺序的，可以获得树中第k大或第k小的数
*
*
* */

public class TreeTraversal {
    // 先序遍历：先根，根节点-->左子树-->右子树
    public List<Integer> preOrder(TreeNode root){
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return null;
        result.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
        return result;
    }

    // 中序遍历：中根，左子树-->根节点-->右子树
    public List<Integer> inOrder(TreeNode root){
        if (root == null) return null;
        LinkedList<Integer> result = new LinkedList<>();
        inOrder(root.left);
        result.add(root.val);
        inOrder(root.right);
        return result;
    }

    // 后序遍历：后根，左子树-->右子树-->根节点
    public List<Integer> postOrder(TreeNode root){
        if (root == null) return null;
        LinkedList<Integer> result = new LinkedList<>();
        postOrder(root.left);
        postOrder(root.right);
        result.add(root.val);
        return result;
    }

    // 层次遍历
    public List<Integer> levelOrder(TreeNode root){
        LinkedList<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return null;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            res.add(cur.val);
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
        return res;
    }
}
