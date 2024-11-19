package leetcode401_500;

import java.util.*;

public class L433_MinimumGeneticMutation_medium {
    // https://leetcode-cn.com/problems/minimum-genetic-mutation/
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) {
            return 0;
        }
        Set<String> cnt = new HashSet<>();
        for (String b: bank) {
            cnt.add(b);
        }
        if (!cnt.contains(endGene)) {
            return -1;
        }
        char[] keys = {'A', 'C', 'G', 'T'};
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        visited.add(startGene);
        int step = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            step++;
            for (int i = 0; i < sz; i++) {
                String cur = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (cur.charAt(j) != keys[k]) {
                            StringBuffer sb = new StringBuffer(cur);
                            sb.setCharAt(j, keys[k]);
                            String next = sb.toString();
                            if (!visited.contains(next) && cnt.contains(next)) {
                                if (next.equals(endGene)) {
                                    return step;
                                }
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
