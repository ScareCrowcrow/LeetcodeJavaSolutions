package leetcode201_300;

public class L237_DeleteNodeInLinkedList_easy {
    // https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
    public static class ListNode {
        int val;
        ListNode next;
    }

    public void deleteNode(ListNode node) {
        // 把下一个节点的值赋给当前节点，把下一个节点删除
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
