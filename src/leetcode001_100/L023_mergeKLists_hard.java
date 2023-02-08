package leetcode001_100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class L023_mergeKLists_hard {
    // https://leetcode-cn.com/problems/merge-k-sorted-lists/
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // 时间复杂度O(NlogK)：其中 k 是链表的条数，N 是这些链表 的节点总数；⼀次 poll 或者 add ⽅法的时间复杂度是 O(logk)
        if (lists.length == 0) return null;
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b)->(a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        // 分治法
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b){
        if (a == null) return b;
        if (b == null) return a;

        if (a.val <= b.val){
            a.next = mergeTwoLists(a.next, b);
            return a;
        }else{
            b.next = mergeTwoLists(a, b.next);
            return b;
        }
    }
}
