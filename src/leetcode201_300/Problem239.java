package leetcode201_300;

import java.util.LinkedList;

// 双端队列的作用：滑动窗口
public class Problem239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] re = {};
        if (k < 1 || nums.length == 0 || k > nums.length) {
            return re;
        }
        re = new int[nums.length - (k - 1)];
        // 双端队列中存储的是数组的index
        LinkedList<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            // 如果队列中的元素个数大于k，则移除队首
            if (!deque.isEmpty() && i - deque.getFirst() >= k) {
                deque.removeFirst();
            }
            // 如果当前元素大于队尾元素，则移除队尾元素
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
