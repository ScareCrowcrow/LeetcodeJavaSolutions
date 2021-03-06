package p1_100;

public class L0024_medium {
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
