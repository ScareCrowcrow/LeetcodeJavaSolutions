package InterviewQuestions;

import java.util.LinkedList;

public class p59_I_simple {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] re = {};
        if (k < 1 || nums.length == 0 || k > nums.length) {
            return re;
        }
        re = new int[nums.length - (k - 1)];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && i - deque.getFirst() >= k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (i >= (k - 1)) {
                re[i - (k - 1)] = nums[deque.getFirst()];
            }
        }
        return re;
    }
}
