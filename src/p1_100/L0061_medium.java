package p1_100;

// TAG: 双指针

public class L0061_medium {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        while (fast != null){
            len++;
            fast = fast.next;
        }
        fast = head;
        for (int i = 0; i < k % len; i++){
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
