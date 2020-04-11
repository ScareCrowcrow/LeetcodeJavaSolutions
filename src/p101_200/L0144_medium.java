package p101_200;

import java.util.ArrayList;
import java.util.List;

public class L0144_medium {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList();
        if(root == null) return res;
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res){
        res.add(root.val);
        if(root.left != null) helper(root.left, res);
        if(root.right != null) helper(root.right, res);
    }
}
