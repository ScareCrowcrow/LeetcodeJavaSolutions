package p701_800;

import java.util.Arrays;
import java.util.Stack;

// TAG: 图的DFS
/*
* 染色法的思路是：
先找到一个没被染色的节点u，把它染上一种颜色，之后遍历所有与它相连的节点v，
* 如果节点v已被染色并且颜色和节点u一样，那么就不是二分图。
* 如果这个节点v没有被染色，先把它染成与节点u不同颜色的颜色，
* 然后遍历所有与节点v相连的节点...如此递归下去。
* */

public class L0785_medium {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int start = 0; start < n; ++start) {
            if (color[start] == -1) {
                Stack<Integer> stack = new Stack();
                stack.push(start);
                color[start] = 0;

                while (!stack.empty()) {
                    Integer node = stack.pop();
                    for (int nei: graph[node]) {
                        if (color[nei] == -1) {
                            stack.push(nei);
                            color[nei] = color[node] ^ 1;
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
