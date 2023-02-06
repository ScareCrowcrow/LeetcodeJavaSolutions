package leetcode501_600;

import java.util.List;

public class L559_MaximumDepthOfNAryTree_easy {
    // https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/
    public class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int curLevelMax = 0;
        for (Node child: root.children) {
            curLevelMax = Math.max(curLevelMax, maxDepth(child));
        }
        return curLevelMax + 1;
    }
}
