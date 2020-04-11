package p501_600;

import java.util.ArrayList;
import java.util.List;

public class L0589_simple {
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> res = new ArrayList();
        if(root == null) return res;
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res){
        res.add(root.val);
        for(Node child: root.children){
            if(child != null){
                helper(child, res);
            }
        }
    }
}
