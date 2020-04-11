package p101_200;

public class L0148_medium {
    public ListNode sortList(ListNode head){
        int len = 0;
        ListNode cur = head;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int m = 1; m < len; m*=2){
            ListNode pre = dummy;
            cur = pre.next;
            while (cur != null){
                // 定义first指针指向第一部分
                ListNode first = cur;
                for (int i = 0; i < m - 1 && cur != null; i++){
                    cur = cur.next;
                }
                if (cur == null) break;
                // 定义second指针指向第二部分
                ListNode second = cur.next;
                // 将第一部分和第二部分断开
                cur.next = null;
                cur = second;
                for (int i = 0; i < m - 1 && cur != null; i++){
                    cur = cur.next;
                }
                ListNode remain = null;
                // 将第二部分与第三部分断开
                if (cur != null){
                    remain = cur.next;
                    cur.next = null;
                }
                cur = remain;
                // 准备开始归并排序，并用tmp指向归并后的头结点
                ListNode tmp = merge(first, second);
                pre.next = tmp;
                // pre节点遍历到归并链表的末尾
                while (pre.next != null){
                    pre = pre.next;
                }
                // 接上剩下未排序的元素
                pre.next = remain;
            }
        }
        return dummy.next;
    }

    private ListNode merge(ListNode a, ListNode b){
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (a != null && b != null){
            boolean check = (a.val < b.val);
            cur.next = check ? a : b;
            cur = cur.next;
            a = check ? a.next : a;
            b = check ? b : b.next;
        }
        cur.next = (a == null) ? b : a;
        return pre.next;
    }
}
