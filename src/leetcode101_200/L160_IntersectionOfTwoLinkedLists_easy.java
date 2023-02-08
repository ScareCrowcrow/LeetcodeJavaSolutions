package leetcode101_200;

public class L160_IntersectionOfTwoLinkedLists_easy {
    // https://leetcode.cn/problems/intersection-of-two-linked-lists/
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 通过某些⽅式，让 p1 和 p2 能够同时到达相交节点
        // 可以让 p1 遍历完链表 A 之后开始遍历链表 B，让 p2 遍历完链表 B 之后开始遍历链表 A，这样相 当于「逻辑上」两条链表接在了⼀起
        // 如果这样进⾏拼接，就可以让 p1 和 p2 同时进⼊公共部分，也就是同时到达相交节点
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 ⾛⼀步，如果⾛到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            // p2 ⾛⼀步，如果⾛到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }
}
