package leetcode401_500;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L428_SerializeAndDeserializeNaryTree_hard {
    // https://leetcode.cn/problems/serialize-and-deserialize-n-ary-tree/
    // 不要提交这个类
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            children = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    // 提交下面这个类
    class Codec {

        public String serialize(Node root) {
            if (root == null) { // 空树！直接返回#
                return "#";
            }
            StringBuilder builder = new StringBuilder();
            serial(builder, root);
            return builder.toString();
        }

        // 当前来到head
        private void serial(StringBuilder builder, Node head) {
            builder.append(head.val + ",");
            if (!head.children.isEmpty()) {
                builder.append("[,");
                for (Node next : head.children) {
                    serial(builder, next);
                }
                builder.append("],");
            }
        }

        public Node deserialize(String data) {
            if (data.equals("#")) {
                return null;
            }
            String[] splits = data.split(",");
            Queue<String> queue = new LinkedList<>();
            for (String str : splits) {
                queue.offer(str);
            }
            return deserial(queue);
        }

        private Node deserial(Queue<String> queue) {
            Node cur = new Node(Integer.valueOf(queue.poll()));
            cur.children = new ArrayList<>();
            if (!queue.isEmpty() && queue.peek().equals("[")) {
                queue.poll();
                while (!queue.peek().equals("]")) {
                    Node child = deserial(queue);
                    cur.children.add(child);
                }
                queue.poll();
            }
            return cur;
        }

    }
}
