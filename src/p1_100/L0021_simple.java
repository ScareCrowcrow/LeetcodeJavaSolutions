package p1_100;

public class L0021_simple {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null){
            boolean check = (l1.val < l2.val);
            cur.next = check ? l1 : l2;
            cur = cur.next;
            l1 = check ? l1.next: l1;
            l2 = check ? l2: l2.next;
        }
        cur.next = (l1 == null) ? l2: l1;
        return dummy.next;
    }
}
