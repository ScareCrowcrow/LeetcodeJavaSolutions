package leetcode001_100;

public class L083_RemoveDuplicatesFromSortedList_easy {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode iter = head;
        while (iter != null && iter.next != null){
            if (iter.val == iter.next.val){
                iter.next = iter.next.next;
            }else{
                iter = iter.next;
            }
        }
        return head;
    }
}
