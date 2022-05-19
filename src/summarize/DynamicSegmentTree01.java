package summarize;

// 开点线段树:
//          适用场景：数值范围很大，使用频率不高
// 只支持单点增加 + 范围查询的动态开点线段树（累加和）
public class DynamicSegmentTree01 {
    public static class Node {
        public int sum;
        public Node left;
        public Node right;
    }

    // arr[0] -> 1
    // 线段树，从1开始下标!
    public static class DynamicSegmentTree {
        public Node root;
        public int size;

        public DynamicSegmentTree(int max) {
            root = new Node();
            size = max;
        }

        // 下标i这个位置的数，增加v
        public void add(int i, int v) {
            add(root, 1, size, i, v);
        }

        // c-> cur 当前节点！表达的范围 l~r
        // i位置的数，增加v
        // 潜台词！i一定在l~r范围上！
        private void add(Node c, int l, int r, int i, int v) {
            if (l == r) {
                c.sum += v;
            } else { // l~r 还可以划分
                int mid = (l + r) / 2;
                if (i <= mid) { // l ~ mid
                    if (c.left == null) {
                        c.left = new Node();
                    }
                    add(c.left, l, mid, i, v);
                } else {  // mid + 1 ~ r
                    if (c.right == null) {
                        c.right = new Node();
                    }
                    add(c.right, mid + 1, r, i, v);
                }
                c.sum = (c.left != null ? c.left.sum : 0) + (c.right != null ? c.right.sum : 0);
            }
        }

        // s~e范围的累加和，告诉我！
        public int query(int s, int e) {
            return query(root, 1, size, s, e);
        }

        // 当前节点c，表达的范围l~r
        // 收到了一个任务，s~e这个任务！
        // s~e这个任务，影响了多少l~r范围的数，把答案返回！
        private int query(Node c, int l, int r, int s, int e) {
            if (c == null) {
                return 0;
            }
            if (s <= l && r <= e) { // 3~6  1~100任务
                return c.sum;
            }
            // 有影响，但又不是全影响
            // l ~ r
            // l~mid    mid+1~r
            int mid = (l + r) / 2;
            // 1~100
            // 1~50  51 ~ 100
            // 任务  s~e  53~76
            if (e <= mid) {
                return query(c.left, l, mid, s, e);
            } else if (s > mid) {
                return query(c.right, mid + 1, r, s, e);
            } else {
                return query(c.left, l, mid, s, e) + query(c.right, mid + 1, r, s, e);
            }
        }
    }
}
