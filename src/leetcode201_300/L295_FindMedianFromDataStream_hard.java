package leetcode201_300;

import java.util.PriorityQueue;

public class L295_FindMedianFromDataStream_hard {
    // https://leetcode-cn.com/problems/find-median-from-data-stream/
    // 如果当前数<=大根堆堆顶，入大根堆
    // 如果当前数>大根堆堆顶，入小根堆
    // 如果两个堆的数量差等于2，多的往少的倒
    // 结果：所有数较小的一半在大根堆内，较大的一半在小根堆内
    class MedianFinder {

        private PriorityQueue<Integer> maxh;
        private PriorityQueue<Integer> minh;

        public MedianFinder() {
            maxh = new PriorityQueue<>((a, b) -> b - a);
            minh = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            if (maxh.isEmpty() || maxh.peek() >= num) {
                maxh.add(num);
            } else {
                minh.add(num);
            }
            balance();
        }

        public double findMedian() {
            if (maxh.size() == minh.size()) {
                return (double) (maxh.peek() + minh.peek()) / 2;
            } else {
                return maxh.size() > minh.size() ? maxh.peek() : minh.peek();
            }
        }

        private void balance() {
            if (Math.abs(maxh.size() - minh.size()) == 2) {
                if (maxh.size() > minh.size()) {
                    minh.add(maxh.poll());
                } else {
                    maxh.add(minh.poll());
                }
            }
        }

    }
}
