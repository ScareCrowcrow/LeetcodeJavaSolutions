package leetcode001_100;

public class L024_SwapPairs_medium {
    // https://leetcode-cn.com/problems/swap-nodes-in-pairs/
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null){
            swapTwoPairs(cur);
            cur = cur.next.next;
        }
        return dummy.next;
    }

    public void swapTwoPairs(ListNode prev){
        ListNode dummy = prev.next;
        prev.next = dummy.next;
        dummy.next = dummy.next.next;
        prev.next.next = dummy;
    }
}
