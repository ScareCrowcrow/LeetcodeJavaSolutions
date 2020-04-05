package InterviewQuestions;

public class p18_simple {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = dummy.next;
        while (cur != null && cur.val != val){
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) pre.next = cur.next;
        return dummy.next;
    }
}
