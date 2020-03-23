package p1_100;

/*
 * 思路：
 * 情况1：l1和l2均在遍历
 *   sum = l1 + l2 + carry
 *   val = sum % 10
 *   carry = sum / 10
 * 情况2：其中一个list已经遍历完，只剩一个list还有值，假设l2遍历结束，只剩l1
 *   sum = l1 + carry
 *   val = sum % 10
 *   carry = sum / 10
 * 情况3：两个list均已遍历结束，查看是否存在上一步的进位
 *   if carry == 1: 创建新节点1
 *
 * */
public class L0002_medium {
    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // 创建一个假表头，结果存在这个list中，返回dummy.next即为结果
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        // 情况1
        while (l1 != null && l2 != null) {
            int digit = l1.val + l2.val + carry;
            int val = digit % 10;
            carry = digit / 10;
            ListNode newNode = new ListNode(val);
            current.next = newNode;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // 情况2：l1 is not null but l2 is null
        while (l1 != null) {
            int val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            current.next = new ListNode(val);
            current = current.next;
            l1 = l1.next;
        }
        // 情况2：l2 is not null but l1 is null
        while (l2 != null) {
            int val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            current.next = new ListNode(val);
            current = current.next;
            l2 = l2.next;
        }
        // 情况3
        if (carry != 0) {
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
