package leetcode301_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L315_CountOfSmallerNumbersAfterSelf_hard {
    // https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
    // 采用了mergeSort求逆序对的思路
    public static class Node1 {
        public int value;
        public int index;

        public Node1(int v, int i) {
            value = v;
            index = i;
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            ans.add(0);
        }
        if (nums.length < 2) {
            return ans;
        }
        Node1[] arr = new Node1[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Node1(nums[i], i);
        }
        process(arr, 0, arr.length - 1, ans);
        return ans;
    }

    public static void process(Node1[] arr, int l, int r, List<Integer> ans) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid, ans);
        process(arr, mid + 1, r, ans);
        merge(arr, l, mid, r, ans);
    }

    public static void merge(Node1[] arr, int l, int m, int r, List<Integer> ans) {
        Node1[] help = new Node1[r - l + 1];
        int i = help.length - 1;
        int p1 = m;
        int p2 = r;
        while (p1 >= l && p2 >= m + 1) {
            if (arr[p1].value > arr[p2].value) {
                ans.set(arr[p1].index, ans.get(arr[p1].index) + p2 - m);
            }
            help[i--] = arr[p1].value > arr[p2].value ? arr[p1--] : arr[p2--];
        }
        while (p1 >= l) {
            help[i--] = arr[p1--];
        }
        while (p2 >= m + 1) {
            help[i--] = arr[p2--];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    // 方法2: 开点线段树
    public static class Node {
        public int sum;
        public Node left;
        public Node right;
    }

    public static class DynamicSegmentTree {
        public Node root;
        public int size;

        public DynamicSegmentTree(int max) {
            root = new Node();
            size = max;
        }

        public void add(int i, int v) {
            add(root, 1, size, i, v);
        }

        private void add(Node c, int l, int r, int i, int v) {
            if (l == r) {
                c.sum += v;
            } else {
                int mid = (l + r) / 2;
                if (i <= mid) {
                    if (c.left == null) {
                        c.left = new Node();
                    }
                    add(c.left, l, mid, i, v);
                } else {
                    if (c.right == null) {
                        c.right = new Node();
                    }
                    add(c.right, mid + 1, r, i, v);
                }
                c.sum = (c.left != null ? c.left.sum : 0) + (c.right != null ? c.right.sum : 0);
            }
        }

        public int query(int s, int e) {
            return query(root, 1, size, s, e);
        }

        private int query(Node c, int l, int r, int s, int e) {
            if (c == null) {
                return 0;
            }
            if (s <= l && r <= e) {
                return c.sum;
            }
            int mid = (l + r) / 2;
            if (e <= mid) {
                return query(c.left, l, mid, s, e);
            } else if (s > mid) {
                return query(c.right, mid + 1, r, s, e);
            } else {
                return query(c.left, l, mid, s, e) + query(c.right, mid + 1, r, s, e);
            }
        }

    }

    public static List<Integer> countSmaller2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            ans.add(0);
        }
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] { nums[i], i };
        }
        Arrays.sort(arr, (a, b) -> (a[0] - b[0]));
        DynamicSegmentTree dst = new DynamicSegmentTree(n);
        for (int[] num : arr) {
            ans.set(num[1], dst.query(num[1] + 1, n));
            dst.add(num[1] + 1, 1);
        }
        return ans;
    }
}
