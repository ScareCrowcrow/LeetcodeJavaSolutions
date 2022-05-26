package leetcode701_800;

import java.util.HashMap;

public class L710_RandomPickWithBlacklist_hard {
    // https://leetcode.cn/problems/random-pick-with-blacklist/
    class Solution {
        int size;
        HashMap<Integer, Integer> mapping = new HashMap<>();
        public Solution(int n, int[] blacklist) {
            size = n - blacklist.length;
            for (int b : blacklist) {
                mapping.put(b, 666);
            }

            int last = n - 1;
            for (int b : blacklist) {
                // 如果 b 已经在区间 [sz, N)
                // 可以直接忽略
                if (b >= size) {
                    continue;
                }
                while (mapping.containsKey(last)) {
                    last--;
                }
                mapping.put(b, last);
                last--;
            }
        }

        public int pick() {
            // 随机选取一个索引
            int index = (int)(Math.random() * size);
            // 这个索引命中了黑名单，
            // 需要被映射到其他位置
            if (mapping.containsKey(index)) {
                return mapping.get(index);
            }
            // 若没命中黑名单，则直接返回
            return index;
        }
    }
}
