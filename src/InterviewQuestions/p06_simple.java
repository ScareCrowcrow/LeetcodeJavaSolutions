package InterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;

public class p06_simple {
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> result = new ArrayList<>();
        if (head == null) return new int[0];
        while (head != null){
            result.add(head.val);
            head = head.next;
        }
        Collections.reverse(result);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }
        return res;
    }
}
