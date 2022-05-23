package leetcode001_100;

public class L086_PartitionList_medium {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        // 用来分割
        ListNode left = dummy;
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        while (curr != null){
            if (prev == left){
                if (curr.val < x) left = left.next;
                prev = curr;
                curr = curr.next;
            }else {
                if (curr.val >= x){
                    prev = curr;
                    curr = curr.next;
                }else {
                    prev.next = curr.next;
                    curr.next = left.next;
                    left.next = curr;
                    left = left.next;
                    curr = prev.next;
                }
            }
        }
        return dummy.next;
    }
}
