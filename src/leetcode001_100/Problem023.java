package leetcode001_100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem023 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        /*
        基于最小堆
        */
        if (lists == null || lists.length == 0) return null;
        // 空表头，方便插入节点
        ListNode dummy = new ListNode(0), cur = dummy;

        int k = lists.length;

        // 定义一个最小堆来保存k个链表节点，将k个链表的头放到最小堆中
        PriorityQueue<ListNode> heap = new PriorityQueue<>(k, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        for (int i = 0; i < k; i++){
            // 初始化
            if(lists[i] != null){
                // 从最小堆中将当前最小节点取出，插入到结果链表中
                heap.offer(lists[i]);
            }
        }
        while (!heap.isEmpty()){
            // 如果发现该节点后还有后续节点，将其点加入到最小堆中
            ListNode node = heap.poll();

            cur.next = node;
            cur = cur.next;

            if (node.next != null){
                heap.offer(node.next);
            }
        }
        // 返回结果链表
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
