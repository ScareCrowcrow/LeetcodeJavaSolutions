package p1_100;

import java.util.Stack;

public class L0025_hard {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 使用栈的思路,需要额外O(k)空间
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode next = dummy.next;
        while (next != null){
            for (int i = 0; i < k && next != null; i++){
                stack.push(next);
                next = next.next;
            }
            if (stack.size() != k) return dummy.next;
            while (stack.size() != 0){
                curr.next = stack.pop();
                curr = curr.next;
            }
            // 记忆下一个push的位置
            curr.next = next;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        // k个一组reverse
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev != null){
            prev = reverse(prev, k);
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode prev, int k){
        ListNode last = prev;
        for (int i = 0; i < k + 1; i++){
            last = last.next;
            if (i != k && last == null) return null;
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
        return tail;
    }
}
