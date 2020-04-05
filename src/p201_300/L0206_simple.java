package p201_300;

public class L0206_simple {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode last = prev;
        while (last != null){
            last = last.next;
        }
        ListNode tail = prev.next;
        ListNode curr = prev.next.next;
        while (curr != last){
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            tail.next = next;
            curr = next;
        }
        return dummy.next;
    }
}
