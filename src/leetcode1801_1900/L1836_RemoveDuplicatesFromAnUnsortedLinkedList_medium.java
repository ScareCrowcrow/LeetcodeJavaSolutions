package leetcode1801_1900;

import java.util.HashMap;

public class L1836_RemoveDuplicatesFromAnUnsortedLinkedList_medium {
    // https://leetcode.cn/problems/remove-duplicates-from-an-unsorted-linked-list/
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        if (head.next == null) {
            return head;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        ListNode temp = head;
        while (temp != null) {
            hashMap.put(temp.val, hashMap.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(-1, head);
        temp = dummy;
        while (temp != null && temp.next != null) {
            if (hashMap.get(temp.next.val) > 1) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return dummy.next;
    }
}
