package leetcode401_500;

import java.util.Arrays;
import java.util.HashSet;

public class L433_MinimumGeneticMutation_medium {
    // https://leetcode-cn.com/problems/minimum-genetic-mutation/
    // 类似于127题
    // 从start和end两个方向深度遍历
    private static final char[] gene = {'A', 'G', 'C', 'T'};
    public static int minMutation(String start, String end, String[] bank) {
        HashSet<String> dict = new HashSet<>(Arrays.asList(bank));
        if (!dict.contains(end)) {
            return -1;
        }
        HashSet<String> startSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> visit = new HashSet<>();
        startSet.add(start);
        endSet.add(end);
        for (int len = 2; !startSet.isEmpty(); len++) {
            // startSet是较小的，endSet是较大的
            HashSet<String> nextSet = new HashSet<>();
            for (String w : startSet) {
                // w -> a(nextSet)
                // a b c
                // 0
                //   1
                //     2
                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c: gene) {
                        if (c != w.charAt(j)) {
                            ch[j] = c;
                            String next = String.valueOf(ch);
                            if (endSet.contains(next)) {
                                return len-1;
                            }
                            if (dict.contains(next) && !visit.contains(next)) {
                                nextSet.add(next);
                                visit.add(next);
                            }
                        }
                    }
                }
            }
            // startSet(小) -> nextSet(某个大小)   和 endSet大小来比
            startSet = (nextSet.size() < endSet.size()) ? nextSet : endSet;
            endSet = (startSet == nextSet) ? endSet : nextSet;
        }
        return -1;
    }
}
