package InterviewQuestions;

public class p02_02_simple {
    // https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
    public int kthToLast(ListNode head, int k) {
        // 快指针先走k步，然后慢指针再走
        ListNode fast = head;
        ListNode slow = head;
        while(k != 0) {
            fast = fast.next;
            k--;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
