package leetcode201_300;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem215 {
    // https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
    // 小根堆
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinHeapComparator());
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        return minHeap.peek();
    }

    public static class MinHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }

    }
}
