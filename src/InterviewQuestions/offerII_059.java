package InterviewQuestions;

import java.util.PriorityQueue;

public class offerII_059 {
    // https://leetcode-cn.com/problems/jBjn9C/
    class KthLargest {
        PriorityQueue<Integer> queue;
        int k;

        public KthLargest(int k, int[] nums) {
            queue = new PriorityQueue<>();
            this.k = k;
            for(int num: nums) {
                queue.add(num);
            }
            while(queue.size() > k) {
                queue.poll();
            }
        }

        public int add(int val) {
            queue.add(val);
            if(queue.size() > k) {
                queue.poll();
            }
            return queue.peek();
        }
    }
}
