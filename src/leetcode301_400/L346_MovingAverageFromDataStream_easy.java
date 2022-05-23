package leetcode301_400;

import java.util.LinkedList;
import java.util.Queue;

public class L346_MovingAverageFromDataStream_easy {
    // https://leetcode.cn/problems/moving-average-from-data-stream/
    class MovingAverage {
        private int size = 0;
        private double sum = 0.0;
        private Queue<Integer> queue = new LinkedList<>();

        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            sum += val;
            queue.offer(val);
            if(queue.size() > this.size) {
                sum -= queue.poll();
            }
            return sum / queue.size();
        }
    }
}
