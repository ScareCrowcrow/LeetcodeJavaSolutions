package leetcode001_100;

import java.util.Stack;

public class L025_ReverseKGroup_hard {
    // https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverseBetween(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /** 反转区间 [a, b) 的元素，注意是左闭右开 */
    ListNode reverseBetween(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null; cur = a; nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
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
