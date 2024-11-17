package leetcode101_200;

import java.util.HashMap;
import java.util.HashSet;

public class L128_LongestConsecutiveSequence_medium {
    // https://leetcode-cn.com/problems/longest-consecutive-sequence/
    public static int longestConsecutive3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (int num: nums) {
            // 头元素
            if (!set.contains(num-1)) {
                int len = 0;
                // 中间元素还在
                while (set.contains(num+len)) {
                    len++;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen;
    }

    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
                int preLen = map.getOrDefault(num - 1, 0);
                int posLen = map.getOrDefault(num + 1, 0);
                int all = preLen + posLen + 1;
                map.put(num - preLen, all);
                map.put(num + posLen, all);
                len = Math.max(len, all);
            }
        }
        return len;
    }

    // 两张表：头表、尾表
    // 每次插入一条记录，如果能接起来，则合并删除历史记录
    public static int longestConsecutive2(int[] nums) {
        HashMap<Integer, Integer> headMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> tailMap = new HashMap<Integer, Integer>();
        HashSet<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (!visited.contains(num)) {
                visited.add(num);
                headMap.put(num, 1);
                tailMap.put(num, 1);
                if (tailMap.containsKey(num - 1)) {
                    int preLen = tailMap.get(num - 1);
                    int preHead = num - preLen;
                    headMap.put(preHead, preLen + 1);
                    tailMap.put(num, preLen + 1);
                    headMap.remove(num);
                    tailMap.remove(num - 1);
                }
                if (headMap.containsKey(num + 1)) {
                    int preLen = tailMap.get(num);
                    int preHead = num - preLen + 1;
                    int postLen = headMap.get(num + 1);
                    int postTail = num + postLen;
                    headMap.put(preHead, preLen + postLen);
                    tailMap.put(postTail, preLen + postLen);
                    headMap.remove(num + 1);
                    tailMap.remove(num);
                }
            }
        }
        int ans = 0;
        for (int len : headMap.values()) {
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
