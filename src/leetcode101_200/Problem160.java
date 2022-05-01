package leetcode101_200;

public class Problem160 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2){
            if (node1 != null){
                node1 = node1.next;
            }else node1 = headB;
            if (node2 != null){
                node2 = node2.next;
            }else node2 = headA;
        }
        return node1;
    }
}