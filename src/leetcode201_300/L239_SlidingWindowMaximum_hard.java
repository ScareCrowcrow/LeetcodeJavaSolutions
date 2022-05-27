package leetcode201_300;

import java.util.LinkedList;

// 双端队列的作用：滑动窗口
public class L239_SlidingWindowMaximum_hard {
    // https://leetcode.cn/problems/sliding-window-maximum/
    public int[] maxSlidingWindow(int[] arr, int w) {
        if(arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] ans = new int[arr.length - w + 1];
        int index = 0;
        for (int R = 0; R < arr.length; R++) {
            while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                qmax.pollLast();
            }
            qmax.addLast(R);
            if(qmax.peekFirst() == R - w) {
                qmax.pollFirst();
            }
            if(R >= w - 1) {
                ans[index++] = arr[qmax.peekFirst()];
            }
        }
        return ans;
    }
}
