package leetcode701_800;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L752_OpenTheLock_medium {
    // https://leetcode.cn/problems/open-the-lock/
    // BFS
    public int openLock(String[] deadends, String target) {
        Set<String> dd = new HashSet<>();
        for (String s : deadends) {
            dd.add(s);
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int count = 0;
        queue.offer("0000");
        visited.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (dd.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return count;
                }
                for (int j = 0; j < 4; j++) {
                    String plus = plusOne(cur, j);
                    if (!visited.contains(plus)) {
                        queue.offer(plus);
                        visited.add(plus);
                    }
                    String minu = minuOne(cur, j);
                    if (!visited.contains(minu)) {
                        queue.offer(minu);
                        visited.add(minu);
                    }
                }

            }
            count++;
        }
        return -1;

    }

    public String plusOne(String s, int j) {
        char[] c = s.toCharArray();
        if (c[j] == '9') {
            c[j] = '0';
        } else {
            c[j] += 1;
        }
        return new String(c);
    }

    public String minuOne(String s, int j) {
        char[] c = s.toCharArray();
        if (c[j] == '0') {
            c[j] = '9';
        } else {
            c[j] -= 1;
        }
        return new String(c);
    }
}
