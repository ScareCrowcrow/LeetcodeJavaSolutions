package leetcode301_400;

import java.util.*;

public class L347_TopKFrequentElements_medium {
    // https://leetcode-cn.com/problems/top-k-frequent-elements/
    public List<Integer> topKFrequent(int[] nums, int k){
        // 词频统计
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int n: nums){
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        // 门槛堆
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2)->count.get(n1) - count.get(n2));
        for (int n: count.keySet()){
            heap.add(n);
            if (heap.size() > k){
                heap.poll();
            }
        }
        List<Integer> top_k = new LinkedList<>();
        while (!heap.isEmpty()){
            top_k.add(heap.poll());
        }
        Collections.reverse(top_k);
        return top_k;
    }

    public static class Node {
        public int num;
        public int count;

        public Node(int k) {
            num = k;
            count = 1;
        }
    }

    public static class CountComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.count - o2.count;
        }

    }

    public static int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Node> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new Node(num));
            } else {
                map.get(num).count++;
            }
        }
        PriorityQueue<Node> heap = new PriorityQueue<>(new CountComparator());
        for (Node node : map.values()) {
            if (heap.size() < k || (heap.size() == k && node.count > heap.peek().count)) {
                heap.add(node);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] ans = new int[k];
        int index = 0;
        while (!heap.isEmpty()) {
            ans[index++] = heap.poll().num;
        }
        return ans;
    }
}
